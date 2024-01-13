package com.example.testtasksw.presentation.screens.register

data class RegisterState(
    val isLoading: Boolean = false,
    val token: String = "",
    val error: String = ""
)
