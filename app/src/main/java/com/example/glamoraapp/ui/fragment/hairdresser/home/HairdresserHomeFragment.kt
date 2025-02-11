package com.example.glamoraapp.ui.fragment.hairdresser.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.glamoraapp.databinding.FragmentHairdresserHomeBinding
import com.example.glamoraapp.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HairdresserHomeFragment :
    BaseFragment<FragmentHairdresserHomeBinding, HairdresserHomeViewModel>() {

    override fun initView() {

    }

    override val viewModel: HairdresserHomeViewModel by viewModels()

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHairdresserHomeBinding =
        FragmentHairdresserHomeBinding.inflate(inflater, container, false)

}