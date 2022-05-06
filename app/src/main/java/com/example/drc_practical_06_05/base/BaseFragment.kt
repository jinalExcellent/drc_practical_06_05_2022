package com.example.drc_practical_06_05.base

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import javax.inject.Inject

abstract class BaseFragment<T : ViewDataBinding, V : ViewModel> : Fragment() {
    abstract val layoutId: Int
    abstract val bindingVariable: Int
    lateinit var activity: Activity

    @Inject
    lateinit var viewModel: V

    lateinit var binding: T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        performDataBinding(inflater, container)
        return binding.root
    }

    private fun performDataBinding(inflater: LayoutInflater, container: ViewGroup?) {
        activity = requireActivity()
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.setVariable(bindingVariable, viewModel)
        binding.executePendingBindings()
    }


}