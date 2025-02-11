package com.example.glamoraapp.ui.fragment.hairdresser.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.glamoraapp.databinding.FragmentHairdresserProfileBinding
import com.example.glamoraapp.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HairdresserProfileFragment :
    BaseFragment<FragmentHairdresserProfileBinding, HairdresserProfileViewModel>() {

    override fun initView() {

    }

    override val viewModel: HairdresserProfileViewModel by viewModels()

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHairdresserProfileBinding =
        FragmentHairdresserProfileBinding.inflate(inflater, container, false)

}