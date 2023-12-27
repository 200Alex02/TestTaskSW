package com.example.testtasksw.presentation.view.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testtasksw.theme.TestTaskSWTheme
import com.example.testtasksw.theme.components.TextFieldCustom

@Preview(showBackground = true)
@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(
            backgroundColor = TestTaskSWTheme.colors.topBarBackground
        ) {
            Text(
                text = "Регистрация",
                color = TestTaskSWTheme.colors.textColor,
                textAlign = TextAlign.Center
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(TestTaskSWTheme.colors.topBarLineColor),
        )
        Column(
            modifier = Modifier.padding(horizontal = 15.dp)
        ) {
            Text(
                text = "e-mail",
                color = TestTaskSWTheme.colors.textColor,
                fontSize = 14.sp
            )
            /*TextFieldCustom()*/
        }
    }
}