package com.example.testtasksw.presentation.screens.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.testtasksw.R
import com.example.testtasksw.presentation.components.ButtonRectangle
import com.example.testtasksw.presentation.components.TextFieldCustom
import com.example.testtasksw.theme.TestTaskSWTheme
import com.example.testtasksw.theme.Typography

@Preview(showBackground = true)
@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TopAppBar(
                backgroundColor = TestTaskSWTheme.colors.topBarBackground
            ) {
                Text(
                    text = stringResource(id = R.string.register),
                    color = TestTaskSWTheme.colors.textColor,
                    style = Typography.h3,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(TestTaskSWTheme.colors.topBarLineColor),
            )
            Spacer(modifier = Modifier.weight(0.3f))
            Column(
                modifier = Modifier
                    .padding(horizontal = 15.dp),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.email),
                    color = TestTaskSWTheme.colors.textColor,
                    style = Typography.body1
                )
                TextFieldCustom(
                    value = viewModel.textEmail,
                    onValueChange = { email ->
                        viewModel.textEmail = email
                    },
                    singleLine = true,
                    placeholder = stringResource(id = R.string.placeholder_email),
                    visualTransformation = VisualTransformation.None
                )
                Text(
                    text = stringResource(id = R.string.password),
                    color = TestTaskSWTheme.colors.textColor,
                    style = Typography.body1,
                    modifier = Modifier.padding(top = 15.dp)
                )
                TextFieldCustom(
                    value = viewModel.textPassword,
                    onValueChange = { password ->
                        viewModel.textPassword = password
                    },
                    singleLine = true,
                    placeholder = stringResource(id = R.string.placeholder_password),
                    visualTransformation = VisualTransformation.None
                )
                Text(
                    text = stringResource(id = R.string.password_repeat),
                    color = TestTaskSWTheme.colors.textColor,
                    style = Typography.body1,
                    modifier = Modifier.padding(top = 15.dp)
                )
                TextFieldCustom(
                    value = viewModel.textPasswordRepeat,
                    onValueChange = { passwordRepeat ->
                        viewModel.textPasswordRepeat = passwordRepeat
                    },
                    singleLine = true,
                    placeholder = stringResource(id = R.string.placeholder_password),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    visualTransformation = PasswordVisualTransformation()
                )

                if (viewModel.checkInputData) {
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 10.dp),
                        text = stringResource(id = R.string.error_input_data),
                        color = Color.Red,
                        style = Typography.h3,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }

                ButtonRectangle(
                    onClick = {
                        if (viewModel.textEmail.isNotEmpty() && viewModel.textPassword.isNotEmpty()) {
                            viewModel.checkInputData = false
                            viewModel.registerUser()
                        } else {
                            viewModel.checkInputData = true
                        }
                    },
                    modifier = Modifier
                        .padding(top = 25.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.register),
                        color = TestTaskSWTheme.colors.textColorButton,
                        style = Typography.h3,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }

                if (state.error.isNotEmpty() || state.token.isEmpty()) {
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 15.dp),
                        text = state.error,
                        color = Color.Red,
                        style = Typography.h3,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
        }

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}