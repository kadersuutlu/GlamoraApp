package com.example.glamoraapp.ui.fragment.hairdresser.register

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.glamoraapp.databinding.FragmentHairdresserRegisterBinding
import com.example.glamoraapp.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HairdresserRegisterFragment :
    BaseFragment<FragmentHairdresserRegisterBinding, HairdresserRegisterViewModel>() {

    override fun initView() {

    }

    override val viewModel by viewModels<HairdresserRegisterViewModel>()

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHairdresserRegisterBinding {
        return FragmentHairdresserRegisterBinding.inflate(inflater, container, false)
    }
}