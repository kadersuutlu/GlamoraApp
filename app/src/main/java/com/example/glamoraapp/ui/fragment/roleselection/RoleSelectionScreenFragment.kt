package com.example.glamoraapp.ui.fragment.roleselection

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.glamoraapp.R
import com.example.glamoraapp.databinding.FragmentRoleSelectionScreenBinding
import com.example.glamoraapp.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoleSelectionScreenFragment :
    BaseFragment<FragmentRoleSelectionScreenBinding, RoleSelectionViewModel>() {

    override fun initView() {
        binding.cardCustomer.setOnClickListener(){
            findNavController().navigate(R.id.action_roleSelectionScreenFragment2_to_customerRegisterFragment)
        }
        binding.cardHairdresser.setOnClickListener{
            findNavController().navigate(R.id.action_roleSelectionScreenFragment2_to_hairdresserRegisterFragment)
        }
    }

    override val viewModel by viewModels<RoleSelectionViewModel>()

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentRoleSelectionScreenBinding {
        return FragmentRoleSelectionScreenBinding.inflate(inflater, container, false)
    }
}