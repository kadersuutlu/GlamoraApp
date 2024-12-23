package com.example.glamoraapp.ui.fragment.customer.login

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.glamoraapp.databinding.FragmentCustomerLoginBinding
import com.example.glamoraapp.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CustomerLoginFragment :
    BaseFragment<FragmentCustomerLoginBinding, CustomerLoginViewModel>() {

    override fun initView() {

    }

    override val viewModel by viewModels<CustomerLoginViewModel>()

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCustomerLoginBinding {
        return FragmentCustomerLoginBinding.inflate(inflater, container, false)
    }
}