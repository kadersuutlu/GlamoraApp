package com.example.glamoraapp.ui.fragment.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
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
        viewModel.isOnboardingFinished.observe(viewLifecycleOwner, Observer { isFinished ->
            lifecycleScope.launch {
                delay(3000)
                if (isFinished) {
                    findNavController().navigate(R.id.action_splashFragment_to_roleSelectionScreenFragment2)
                } else {
                    findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment2)
                }
            }
        })
    }

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSplashBinding {
        return FragmentSplashBinding.inflate(inflater, container, false)
    }

    override val viewModel by viewModels<SplashViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}