package com.example.glamoraapp.ui.fragment.customer.register

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.glamoraapp.R
import com.example.glamoraapp.model.CustomerUsersModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class CustomerRegisterViewModel @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firebaseDatabase: FirebaseDatabase,
    private val firebaseFirestore: FirebaseFirestore,
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val _registerState = MutableLiveData<String>()
    val registerState: LiveData<String> get() = _registerState

    fun registerCustomer(
        fullName: String,
        phoneNumber: String,
        email: String,
        password: String,
        passwordAgain: String
    ) {
        if (fullName.isEmpty() || phoneNumber.isEmpty() || email.isEmpty() || password.isEmpty() || passwordAgain.isEmpty()) {
            _registerState.value = context.getString(R.string.register_error_empty_fields)
            return
        }

        if (password != passwordAgain) {
            _registerState.value = context.getString(R.string.register_error_passwords_not_match)
            return
        }

        if (!isPasswordValid(password)) {
            _registerState.value = context.getString(R.string.register_error_invalid_password)
            return
        }

        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = firebaseAuth.currentUser
                    val customer = CustomerUsersModel(
                        fullName = fullName,
                        phoneNumber = phoneNumber,
                        email = email,
                        password = password,
                        role = "customer"
                    )

                    saveCustomerToDatabase(user?.uid, customer)
                } else {
                    _registerState.value = task.exception?.message
                        ?: context.getString(R.string.register_error_failed_registration)
                }
            }
    }

    private fun saveCustomerToDatabase(userId: String?, customer: CustomerUsersModel) {
        if (userId == null) {
            _registerState.value = context.getString(R.string.register_error_save_failed)
            return
        }

        val databaseReference = firebaseDatabase.reference.child("customers")
        databaseReference.child(userId).setValue(customer)
            .addOnCompleteListener { databaseTask ->
                if (databaseTask.isSuccessful) {
                    saveCustomerToFirestore(userId, customer)
                } else {
                    _registerState.value = context.getString(
                        R.string.register_error_realtime_db,
                        databaseTask.exception?.message ?: "Unknown error"
                    )
                }
            }
    }

    private fun saveCustomerToFirestore(userId: String, customer: CustomerUsersModel) {
        firebaseFirestore.collection("customers").document(userId)
            .set(customer)
            .addOnCompleteListener { firestoreTask ->
                if (firestoreTask.isSuccessful) {
                    _registerState.value = context.getString(R.string.register_success)
                } else {
                    _registerState.value = context.getString(
                        R.string.register_error_firestore,
                        firestoreTask.exception?.message ?: "Unknown error"
                    )
                }
            }
    }

    fun isPasswordValid(password: String): Boolean {
        val passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}\$"
        return password.matches(Regex(passwordPattern))
    }
}