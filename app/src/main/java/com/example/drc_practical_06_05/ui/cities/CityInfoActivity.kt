package com.example.drc_practical_06_05.ui.cities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.drc_practical_06_05.BR
import com.example.drc_practical_06_05.R
import com.example.drc_practical_06_05.base.BaseActivity
import com.example.drc_practical_06_05.databinding.ActivityCityInfoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CityInfoActivity : BaseActivity<ActivityCityInfoBinding, CityInfoViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override val layoutId: Int
        get() = R.layout.activity_main
    override val bindingVariable: Int
        get() = BR.viewModel
}