package com.example.testtasksw.presentation.screens.coffeeShops

import com.example.testtasksw.domain.model.CoffeeShop

data class CoffeeShopsState(
    val coffeeShops: List<CoffeeShop> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)
