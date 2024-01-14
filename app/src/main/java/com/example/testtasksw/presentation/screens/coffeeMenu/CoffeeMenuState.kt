package com.example.testtasksw.presentation.screens.coffeeMenu

import com.example.testtasksw.domain.model.CoffeeMenu

data class CoffeeMenuState(
    val coffeeMenu: List<CoffeeMenu> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)
