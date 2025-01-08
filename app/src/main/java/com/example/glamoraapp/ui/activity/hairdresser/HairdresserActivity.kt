package com.example.glamoraapp.ui.activity.hairdresser

import android.view.LayoutInflater
import androidx.activity.viewModels
import com.example.glamoraapp.databinding.ActivityHairdresserBinding
import com.example.glamoraapp.ui.BaseActivity

class HairdresserActivity : BaseActivity<ActivityHairdresserBinding, HairdresserViewModel>() {
    override val viewModel: HairdresserViewModel by viewModels()

    override fun createViewBinding(inflater: LayoutInflater): ActivityHairdresserBinding {
        return ActivityHairdresserBinding.inflate(inflater)
    }
    override fun initView() {

    }

}