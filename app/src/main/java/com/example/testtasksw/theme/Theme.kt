package com.example.testtasksw.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class Colors(
    // Цвет текста по умолчанию
    val textColor: Color = Color(0XFF846340),
    val topBarBackground: Color = Color(0XFFFAF9F9),
    val topBarLineColor: Color = Color(0XFFC2C2C2),
    val buttonRectangleBackground: Color = Color(0XFF342D1A),
    val textColorForTextField: Color = Color(0XFFAF9479),
    val textFieldBackground: Color = Color.White,

)

private val LightColors = Colors()

private val DarkColors = Colors()

// Определение CompositionLocal для хранения цветов
val LocalExtendedColors = staticCompositionLocalOf {
    Colors()
}

@Composable
fun TestTaskSWTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    // Определение цветовой схемы в зависимости от выбранной темы
    val colors = if (!darkTheme) {
        LightColors
    } else {
        DarkColors
    }

    // Используем CompositionLocalProvider для предоставления цветовой схемы
    CompositionLocalProvider(LocalExtendedColors provides colors) {
        MaterialTheme(
            typography = Typography,
            content = content
        )
    }
}

// Объект для получения текущей цветовой схемы из CompositionLocal
object TestTaskSWTheme {
    val colors: Colors
        @Composable
        get() = LocalExtendedColors.current
}



