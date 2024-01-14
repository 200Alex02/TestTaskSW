package com.example.testtasksw.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.testtasksw.presentation.ui.theme.TestTaskSWTheme

@Composable
fun ButtonRectangle(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    backgroundColor: Color = TestTaskSWTheme.colors.buttonRectangleBackground,
    enabled: Boolean = true,
    content: @Composable () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
        contentPadding = PaddingValues(vertical = 13.dp, horizontal = 16.dp),
        shape = RoundedCornerShape(24.dp),
        elevation = ButtonDefaults.elevation(0.dp),
        enabled = enabled
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            content()
        }
    }
}
