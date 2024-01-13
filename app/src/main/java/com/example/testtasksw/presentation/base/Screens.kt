package com.example.testtasksw.presentation.base

sealed class Screens(
    val route: String
) {
    object RegisterScreen: Screens(route = "register_screen")

    object LoginScreen: Screens(route = "login_screen")

    object CoffeeShopsScreen: Screens(route = "coffee_shops_screen")
}