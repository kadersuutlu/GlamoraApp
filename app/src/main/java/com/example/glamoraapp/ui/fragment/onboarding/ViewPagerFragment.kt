package com.example.glamoraapp.ui.fragment.onboarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.glamoraapp.databinding.FragmentViewPagerBinding
import com.example.glamoraapp.ui.BaseFragment
import com.example.glamoraapp.ui.adapter.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ViewPagerFragment : BaseFragment<FragmentViewPagerBinding, ViewPagerViewModel>() {

    override fun initView() {
        viewModel.fragmentList.observe(viewLifecycleOwner, Observer { fragmentList ->
            val adapter =
                ViewPagerAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)
            binding.viewPager2.adapter = adapter
        })
    }

    override val viewModel by viewModels<ViewPagerViewModel>()

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentViewPagerBinding {
        return FragmentViewPagerBinding.inflate(inflater, container, false)
    }
}