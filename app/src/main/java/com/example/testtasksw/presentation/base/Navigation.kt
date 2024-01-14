package com.example.testtasksw.presentation.base

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.testtasksw.presentation.screens.coffeeMenu.CoffeeMenuScreen
import com.example.testtasksw.presentation.screens.coffeeShops.CoffeeShopsScreen
import com.example.testtasksw.presentation.screens.login.LoginScreen
import com.example.testtasksw.presentation.screens.register.RegisterScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Navigation(
    scaffoldState: ScaffoldState,
    navController: NavHostController,
    onRegisterBtnClick: () -> Unit,
    onLoginBtnClick: () -> Unit,
    onBackCoffeeShopClick: () -> Unit,
    onCoffeeShopClick: (Int) -> Unit,

) {
    Scaffold(
        scaffoldState = scaffoldState
    ) { innerPaddings ->
        NavHost(
            modifier = Modifier.padding(innerPaddings),
            navController = navController,
            startDestination = Screens.RegisterScreen.route
        ) {
            composable(route = Screens.RegisterScreen.route) {
                RegisterScreen(onRegisterBtnClick = onRegisterBtnClick)
            }

            composable(route = Screens.LoginScreen.route) {
                LoginScreen(onLoginBtnClick = onLoginBtnClick)
            }

            composable(route = Screens.CoffeeShopsScreen.route) {
                CoffeeShopsScreen(
                    onBackCoffeeShopClick = onBackCoffeeShopClick,
                    onCoffeeShopClick = {id ->
                        onCoffeeShopClick(id)
                    }
                )
            }

            composable(route = Screens.CoffeeMenuScreen.route) {
                CoffeeMenuScreen()
            }
        }
    }
}