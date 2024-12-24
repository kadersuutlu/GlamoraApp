package com.example.glamoraapp.model

data class HairdresserUsersModel(
    val fullName: String,
    val businessName: String,
    val phoneNumber: String,
    val email: String,
    val password: String,
    val businessAddress: String,
    val workingHours: String,
    val services: List<String>,
    val role: String = "hairdresser"
)