package com.example.glamoraapp.ui.fragment.customer.register

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.glamoraapp.R
import com.example.glamoraapp.databinding.FragmentCustomerRegisterBinding
import com.example.glamoraapp.ui.BaseFragment
import com.example.glamoraapp.ui.activity.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CustomerRegisterFragment :
    BaseFragment<FragmentCustomerRegisterBinding, CustomerRegisterViewModel>() {

    override fun initView() {
        binding.letLogIn.setOnClickListener {
            findNavController().navigate(R.id.action_customerRegisterFragment_to_customerLoginFragment)
        }

        binding.registerButton.setOnClickListener {
            val fullName = binding.nameInput.editText?.text.toString()
            val phoneNumber = binding.phoneNumberInput.editText?.text.toString()
            val email = binding.emailInput.editText?.text.toString()
            val password = binding.passwordInput.editText?.text.toString()
            val passwordAgain = binding.passwordAgainInput.editText?.text.toString()

            viewModel.registerCustomer(fullName, phoneNumber, email, password, passwordAgain)

            viewModel.registerState.observe(viewLifecycleOwner) { state ->
                if (state == getString(R.string.register_success)) {
                    val sharedPreferences =
                        requireActivity().getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
                    sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()

                    val intent = Intent(requireContext(), MainActivity::class.java)
                    startActivity(intent)
                    activity?.finish()
                } else {
                    Toast.makeText(requireContext(), state, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun observeViewModel() {
        viewModel.registerState.observe(viewLifecycleOwner) { message ->
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        }
    }

    override val viewModel by viewModels<CustomerRegisterViewModel>()

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCustomerRegisterBinding {
        return FragmentCustomerRegisterBinding.inflate(inflater, container, false)
    }
}