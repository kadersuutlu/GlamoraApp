package com.example.glamoraapp.ui.activity

import android.view.LayoutInflater
import androidx.activity.viewModels
import com.example.glamoraapp.databinding.ActivityMainBinding
import com.example.glamoraapp.ui.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val viewModel: MainViewModel by viewModels()

    override fun createViewBinding(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }

    override fun initView() {
        supportActionBar?.hide()
    }
}