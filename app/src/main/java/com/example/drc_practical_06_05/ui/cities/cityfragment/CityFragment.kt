package com.example.drc_practical_06_05.ui.cities.cityfragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SearchView
import com.example.drc_practical_06_05.BR
import com.example.drc_practical_06_05.R
import com.example.drc_practical_06_05.base.BaseFragment
import com.example.drc_practical_06_05.databinding.FragmentCityBinding
import com.example.drc_practical_06_05.ui.cities.CityList
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import java.io.IOException
import java.io.InputStream


@AndroidEntryPoint
class CityFragment : BaseFragment<FragmentCityBinding, CityInfoViewModel>() {
    var cityList: CityList? = null
    var cityListData = ArrayList<CityList.CityListItem>()
    var searchData = ArrayList<CityList.CityListItem>()
    lateinit var cityAdapter: CityAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getCityJsonData()

        binding.searchData.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                search(query)
                Log.d("TAG",query.toString())
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if(newText.isNullOrEmpty())
                {
                    getCityJsonData()
                }else
                {
                    search(newText)
                    Log.d("TAG","newText "+newText.toString())
                }

                return true
            }
        })
    }

    private fun search(searchText: String?) {
        searchText?.let {
            cityListData?.forEach { city ->
                if (city.name.contains(searchText, true) ||
                    city.country.contains(searchText, true)
                ) {
                    searchData.add(city)
                    cityAdapter = CityAdapter(activity, searchData!!)
                    binding.rvCity.adapter = cityAdapter
                }
            }
        }
    }

    private fun getCityJsonData() {
        try {
            val myJson: String =
                inputStreamToString(activity.resources.openRawResource(R.raw.cities))!!
            cityList = Gson().fromJson(myJson, CityList::class.java)
            cityListData.addAll(cityList!!)
            cityAdapter = CityAdapter(activity, cityListData!!)
            binding.rvCity.adapter = cityAdapter
        } catch (ioException: IOException) {
            ioException.printStackTrace()

        }

    }

    private fun inputStreamToString(inputStream: InputStream): String? {
        return try {
            val bytes = ByteArray(inputStream.available())
            inputStream.read(bytes, 0, bytes.size)
            String(bytes)
        } catch (e: IOException) {
            return null
        }


    }

    override val layoutId: Int
        get() = R.layout.fragment_city
    override val bindingVariable: Int
        get() = BR.viewModel

}