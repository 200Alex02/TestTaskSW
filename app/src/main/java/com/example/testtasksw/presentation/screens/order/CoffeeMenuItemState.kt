package com.example.testtasksw.presentation.screens.order

import com.example.testtasksw.domain.model.SelectedCoffee

data class CoffeeMenuItemState(
    val coffeeMenu: List<SelectedCoffee> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)
