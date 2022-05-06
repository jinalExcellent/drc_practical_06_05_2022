package com.example.drc_practical_06_05.ui.cities

import android.os.Bundle
import com.example.drc_practical_06_05.BR
import com.example.drc_practical_06_05.R
import com.example.drc_practical_06_05.base.BaseActivity
import com.example.drc_practical_06_05.databinding.ActivityCityInfoBinding
import com.example.drc_practical_06_05.ui.cities.cityfragment.CityFragment
import com.example.drc_practical_06_05.ui.cities.cityfragment.CityInfoViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CityInfoActivity : BaseActivity<ActivityCityInfoBinding, CityInfoViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         callFragment()

    }
    override val layoutId: Int
        get() = R.layout.activity_city_info
    override val bindingVariable: Int
        get() = BR.viewModel

    private fun callFragment() {
        var mainFragment: CityFragment = CityFragment()
        supportFragmentManager.beginTransaction().add(R.id.container, mainFragment)
            .commit()
    }


}