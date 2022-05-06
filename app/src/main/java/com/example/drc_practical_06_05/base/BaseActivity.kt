package com.example.drc_practical_06_05.base

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import javax.inject.Inject

abstract class BaseActivity<T : ViewDataBinding, V : ViewModel> : AppCompatActivity() {
    abstract val layoutId: Int
    abstract val bindingVariable: Int
    lateinit var activity: Activity
    lateinit var binding: T
    @Inject
    lateinit var viewModel: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
    }

    private fun performDataBinding() {
        activity = this
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.setVariable(bindingVariable, viewModel)
        binding.executePendingBindings()
    }

}
