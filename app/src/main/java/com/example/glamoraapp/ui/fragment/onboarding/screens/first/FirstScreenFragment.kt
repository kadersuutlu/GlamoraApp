package com.example.glamoraapp.ui.fragment.onboarding.screens.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.example.glamoraapp.R
import com.example.glamoraapp.databinding.FragmentFirstScreenBinding
import com.example.glamoraapp.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstScreenFragment : BaseFragment<FragmentFirstScreenBinding, FirstScreenViewModel>() {

    override fun initView() {
        viewModel.currentPage.observe(viewLifecycleOwner, Observer { currentPage ->
            val viewPager = requireActivity().findViewById<ViewPager2>(R.id.viewPager2)
            viewPager?.currentItem = currentPage
        })

        binding.next.setOnClickListener {
            viewModel.goToNextPage()
        }
    }

    override val viewModel by viewModels<FirstScreenViewModel>()

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFirstScreenBinding {
        return FragmentFirstScreenBinding.inflate(inflater, container, false)
    }
}