package com.example.testtasksw.data.remote.model

data class LoginResponse(
    val token: String,
    val tokenLifetime: Int
)
