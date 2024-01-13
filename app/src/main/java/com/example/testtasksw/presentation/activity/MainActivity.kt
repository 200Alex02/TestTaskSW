package com.example.testtasksw.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.rememberScaffoldState
import androidx.navigation.compose.rememberNavController
import com.example.testtasksw.presentation.base.Navigation
import com.example.testtasksw.presentation.base.Screens
import com.example.testtasksw.theme.TestTaskSWTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState = rememberScaffoldState()
            val navController = rememberNavController()

            TestTaskSWTheme {
                Navigation(
                    scaffoldState = scaffoldState,
                    navController = navController,
                    onRegisterBtnClick = {
                        navController.navigate(route = Screens.LoginScreen.route)
                    },
                    onLoginBtnClick = {
                        navController.navigate(route = Screens.CoffeeShopsScreen.route)
                    },
                    onBackCoffeeShopClick = {
                        navController.navigate(route = Screens.LoginScreen.route)
                    },
                    onCoffeeShopClick = {

                    }
                )
            }
        }
    }
}