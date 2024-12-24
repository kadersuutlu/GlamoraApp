package com.example.glamoraapp.model

data class CustomerUsersModel(
    val fullName: String,
    val phoneNumber: String,
    val email: String,
    val password: String,
    val role: String = "customer"
)