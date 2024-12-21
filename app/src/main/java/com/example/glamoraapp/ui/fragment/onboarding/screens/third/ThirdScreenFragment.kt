package com.example.glamoraapp.ui.fragment.onboarding.screens.third

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.glamoraapp.R
import com.example.glamoraapp.databinding.FragmentThirdScreenBinding
import com.example.glamoraapp.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ThirdScreenFragment : BaseFragment<FragmentThirdScreenBinding, ThirdScreenViewModel>() {

    override fun initView() {
        viewModel.navigateToRoleSelection.observe(viewLifecycleOwner, Observer { navigate ->
            if (navigate) {
                findNavController().navigate(R.id.action_viewPagerFragment2_to_roleSelectionScreenFragment2)
            }
        })

        binding.finish.setOnClickListener {
            viewModel.onBoardingFinished(requireContext())
        }
    }



    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentThirdScreenBinding {
        return FragmentThirdScreenBinding.inflate(inflater, container, false)
    }

    override val viewModel by viewModels<ThirdScreenViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
}