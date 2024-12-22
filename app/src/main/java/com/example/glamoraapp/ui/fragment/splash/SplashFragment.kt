package com.example.glamoraapp.ui.fragment.splash

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.glamoraapp.R
import com.example.glamoraapp.databinding.FragmentSplashBinding
import com.example.glamoraapp.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding, SplashViewModel>() {

    override fun initView() {
        lifecycleScope.launch {
            delay(3000)
            if (viewModel.checkOnboardingStatus()) {
                findNavController().navigate(R.id.action_splashFragment_to_roleSelectionScreenFragment2)
            } else {
                findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment2)
            }
        }
    }

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSplashBinding {
        return FragmentSplashBinding.inflate(inflater, container, false)
    }

    override val viewModel by viewModels<SplashViewModel>()

}