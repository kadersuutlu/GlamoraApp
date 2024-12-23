package com.example.glamoraapp.ui.fragment.customer.register

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.glamoraapp.databinding.FragmentCustomerRegisterBinding
import com.example.glamoraapp.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CustomerRegisterFragment :
    BaseFragment<FragmentCustomerRegisterBinding, CustomerRegisterViewModel>() {

    override fun initView() {

    }

    override val viewModel by viewModels<CustomerRegisterViewModel>()

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCustomerRegisterBinding {
        return FragmentCustomerRegisterBinding.inflate(inflater, container, false)
    }
}