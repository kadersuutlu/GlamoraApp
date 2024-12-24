package com.example.glamoraapp.ui.fragment.hairdresser.login

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.glamoraapp.R
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class HairdresserLoginViewModel @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val _loginSuccess = MutableLiveData<Boolean>()
    val loginSuccess: LiveData<Boolean> get() = _loginSuccess

    private val _resetPasswordSuccess = MutableLiveData<Boolean>()
    val resetPasswordSuccess: LiveData<Boolean> get() = _resetPasswordSuccess

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun signInUser(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _loginSuccess.value = true
                } else {
                    _loginSuccess.value = false
                    _errorMessage.value = context.getString(R.string.login_error_failed)
                }
            }
    }

    fun resetPassword(email: String) {
        firebaseAuth.sendPasswordResetEmail(email)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _resetPasswordSuccess.value = true
                } else {
                    _resetPasswordSuccess.value = false
                    _errorMessage.value = context.getString(R.string.reset_password_error_failed)
                }
            }
    }
}