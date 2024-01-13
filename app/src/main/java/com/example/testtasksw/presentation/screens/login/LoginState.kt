package com.example.testtasksw.presentation.screens.login

data class LoginState(
    val isLoading: Boolean = false,
    val token: String = "",
    val error: String = ""
)
