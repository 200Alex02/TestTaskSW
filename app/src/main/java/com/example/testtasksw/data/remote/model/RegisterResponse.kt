package com.example.testtasksw.data.remote.model

data class RegisterResponse(
    val token: String,
    val tokenLifetime: Int
)