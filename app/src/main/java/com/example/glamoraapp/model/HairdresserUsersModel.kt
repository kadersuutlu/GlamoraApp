package com.example.glamoraapp.model

data class HairdresserUsersModel(
    val businessName: String,
    val phoneNumber: String,
    val email: String,
    val password: String,
    val businessAddress: String = "",
    val workingHours: String = "",
    val services: List<String> = emptyList(),
    val role: String = "hairdresser"
)