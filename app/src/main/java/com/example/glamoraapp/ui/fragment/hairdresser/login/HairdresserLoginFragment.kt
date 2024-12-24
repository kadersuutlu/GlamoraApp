package com.example.glamoraapp.ui.fragment.hairdresser.login

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.glamoraapp.R
import com.example.glamoraapp.databinding.FragmentHairdresserLoginBinding
import com.example.glamoraapp.ui.BaseFragment
import com.example.glamoraapp.ui.activity.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HairdresserLoginFragment :
    BaseFragment<FragmentHairdresserLoginBinding, HairdresserLoginViewModel>() {

    override fun initView() {
        loginButtonAction()

        forgetPasswordAction()

        loginSuccessAction()

        resetPasswordAction()
    }

    private fun loginButtonAction() {
        binding.loginButton.setOnClickListener {
            val email = binding.emailInput.editText?.text.toString()
            val password = binding.passwordInput.editText?.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                viewModel.signInUser(email, password)
            } else {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.error_empty_fields),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun forgetPasswordAction() {
        binding.forgotPasswordText.setOnClickListener {
            val email = binding.emailInput.editText?.text.toString()
            if (email.isNotEmpty()) {
                viewModel.resetPassword(email)
            } else {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.error_invalid_email),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun loginSuccessAction() {
        viewModel.loginSuccess.observe(viewLifecycleOwner) { isSuccess ->
            if (isSuccess) {
                val sharedPreferences =
                    requireActivity().getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
                sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()

                val intent = Intent(requireContext(), MainActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            } else {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.login_failed),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun resetPasswordAction() {
        viewModel.resetPasswordSuccess.observe(viewLifecycleOwner) { isSuccess ->
            if (isSuccess) {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.reset_password_email_sent),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.reset_password_failed),
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) { errorMessage ->
            Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
        }
    }

    override val viewModel by viewModels<HairdresserLoginViewModel>()

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHairdresserLoginBinding {
        return FragmentHairdresserLoginBinding.inflate(inflater, container, false)
    }
}