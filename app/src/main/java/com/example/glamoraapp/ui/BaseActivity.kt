package com.example.glamoraapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<T : ViewBinding, VM : ViewModel> : AppCompatActivity() {

    private var _binding: T? = null
    protected val binding get() = _binding!!
    abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = createViewBinding(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    abstract fun createViewBinding(inflater: LayoutInflater): T
    abstract fun initView()

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
