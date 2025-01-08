package com.example.glamoraapp.ui.activity.customer

import android.view.LayoutInflater
import androidx.activity.viewModels
import com.example.glamoraapp.databinding.ActivityCustomerBinding
import com.example.glamoraapp.ui.BaseActivity

class CustomerActivity : BaseActivity<ActivityCustomerBinding, CustomerViewModel>() {
    override val viewModel: CustomerViewModel by viewModels()

    override fun createViewBinding(inflater: LayoutInflater): ActivityCustomerBinding {
        return ActivityCustomerBinding.inflate(inflater)
    }
    override fun initView() {

    }
}