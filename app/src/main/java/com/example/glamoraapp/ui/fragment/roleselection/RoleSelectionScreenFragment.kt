package com.example.glamoraapp.ui.fragment.roleselection

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.glamoraapp.databinding.FragmentRoleSelectionScreenBinding
import com.example.glamoraapp.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoleSelectionScreenFragment :
    BaseFragment<FragmentRoleSelectionScreenBinding, RoleSelectionViewModel>() {

    override fun initView() {

    }

    override val viewModel by viewModels<RoleSelectionViewModel>()

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentRoleSelectionScreenBinding {
        return FragmentRoleSelectionScreenBinding.inflate(inflater, container, false)
    }
}