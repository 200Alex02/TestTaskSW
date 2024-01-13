package com.example.testtasksw.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.testtasksw.presentation.screens.login.LoginScreen
import com.example.testtasksw.theme.TestTaskSWTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestTaskSWTheme {
                LoginScreen()
            }
        }
    }
}