package com.example.glamoraapp.ui.fragment.hairdresser.login

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.glamoraapp.databinding.FragmentHairdresserLoginBinding
import com.example.glamoraapp.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HairdresserLoginFragment :
    BaseFragment<FragmentHairdresserLoginBinding, HairdresserLoginViewModel>() {

    override fun initView() {

    }

    override val viewModel by viewModels<HairdresserLoginViewModel>()

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHairdresserLoginBinding {
        return FragmentHairdresserLoginBinding.inflate(inflater, container, false)
    }
}