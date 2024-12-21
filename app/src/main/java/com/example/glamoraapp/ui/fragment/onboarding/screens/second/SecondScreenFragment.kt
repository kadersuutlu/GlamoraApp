package com.example.glamoraapp.ui.fragment.onboarding.screens.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.example.glamoraapp.R
import com.example.glamoraapp.databinding.FragmentSecondScreenBinding
import com.example.glamoraapp.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondScreenFragment : BaseFragment<FragmentSecondScreenBinding, SecondScreenViewModel>() {

    override fun initView() {
        viewModel.currentPage.observe(viewLifecycleOwner, Observer { currentPage ->
            val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager2)
            viewPager?.currentItem = currentPage
        })

        binding.next2.setOnClickListener {
            viewModel.goToNextPage()
        }
    }

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSecondScreenBinding {
        return FragmentSecondScreenBinding.inflate(inflater, container, false)
    }

    override val viewModel by viewModels<SecondScreenViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
}