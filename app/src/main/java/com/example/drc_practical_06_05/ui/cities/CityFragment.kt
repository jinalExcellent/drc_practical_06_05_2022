package com.example.drc_practical_06_05.ui.cities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.drc_practical_06_05.BR
import com.example.drc_practical_06_05.R
import com.example.drc_practical_06_05.base.BaseFragment
import com.example.drc_practical_06_05.databinding.FragmentCityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CityFragment : BaseFragment<FragmentCityBinding, CityInfoViewModel>() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override val layoutId: Int
        get() = R.layout.fragment_city
    override val bindingVariable: Int
        get() = BR.viewModel

}