package com.example.drc_practical_06_05.ui.cities.cityfragment

import android.os.Bundle
import android.util.Log
import android.view.View
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
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getCityJsonData()
    }

    private fun getCityJsonData() {
        try {
            val myJson: String = inputStreamToString(activity.resources.openRawResource(R.raw.cities))!!
            Log.d("==>CITY DATA : ","myJson gson: $myJson")
            val myModel: CityList = Gson().fromJson(myJson, CityList::class.java)
            Log.d("==>CITY DATA : ","myModel size: ${myModel.size}")
            var adapter = CityAdapter(activity, myModel)
            binding.rvCity.adapter = adapter

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