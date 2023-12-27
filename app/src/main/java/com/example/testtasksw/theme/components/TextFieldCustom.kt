package com.example.testtasksw.theme.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.testtasksw.theme.TestTaskSWTheme

@Composable
fun TextFieldCustom(
    value: String,
    onValueChange: (String) -> Unit,
    singleLine: Boolean,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    enabled: Boolean = true,
    trailingIcon: @Composable (() -> Unit)? = null
) {

    // Задаем цвета полю
    val outlineTextFieldColors = TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = TestTaskSWTheme.colors.textColor,
        unfocusedBorderColor = TestTaskSWTheme.colors.textColor,
        textColor = TestTaskSWTheme.colors.textColorForTextField,
        backgroundColor = TestTaskSWTheme.colors.textFieldBackground
    )

    OutlinedTextField(
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        modifier = modifier
            .fillMaxWidth(),
        placeholder = { Text(text = placeholder, color = TestTaskSWTheme.colors.textColorForTextField) },
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        colors = outlineTextFieldColors,
        shape = RoundedCornerShape(16.dp),
        singleLine = singleLine,
        trailingIcon = trailingIcon,
        enabled = enabled,
    )
}
