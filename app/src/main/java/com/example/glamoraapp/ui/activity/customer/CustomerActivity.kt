package com.example.glamoraapp.ui.activity.customer

import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.glamoraapp.R
import com.example.glamoraapp.databinding.ActivityCustomerBinding
import com.example.glamoraapp.ui.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CustomerActivity : BaseActivity<ActivityCustomerBinding, CustomerViewModel>() {
    override val viewModel: CustomerViewModel by viewModels()

    private lateinit var navController: NavController

    override fun createViewBinding(inflater: LayoutInflater): ActivityCustomerBinding {
        return ActivityCustomerBinding.inflate(inflater)
    }

    override fun initView() {
        supportActionBar?.hide()
        initNavFragment()

    }

    private fun initNavFragment() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_customer) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNavCustomer.setupWithNavController(navController)
    }
}