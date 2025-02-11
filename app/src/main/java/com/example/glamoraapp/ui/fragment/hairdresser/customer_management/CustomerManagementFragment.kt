package com.example.glamoraapp.ui.fragment.hairdresser.customer_management

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.glamoraapp.databinding.FragmentCustomerManagementBinding
import com.example.glamoraapp.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CustomerManagementFragment :
    BaseFragment<FragmentCustomerManagementBinding, CustomerManagementViewModel>() {

    override fun initView() {
    }

    override val viewModel: CustomerManagementViewModel by viewModels()


    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCustomerManagementBinding =
        FragmentCustomerManagementBinding.inflate(inflater, container, false)

}