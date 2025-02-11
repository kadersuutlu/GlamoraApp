package com.example.glamoraapp.ui.fragment.customer.appointment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.glamoraapp.databinding.FragmentAppointmentBinding
import com.example.glamoraapp.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppointmentFragment : BaseFragment<FragmentAppointmentBinding, AppointmentViewModel>() {

    override fun initView() {
    }

    override val viewModel: AppointmentViewModel by viewModels()

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAppointmentBinding = FragmentAppointmentBinding.inflate(inflater, container, false)

}