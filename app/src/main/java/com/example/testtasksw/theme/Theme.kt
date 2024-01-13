package com.example.testtasksw.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class Colors(
    val textColor: Color = Color(0XFF846340),
    val textColorButton: Color = Color(0XFFF6E5D1),
    val topBarBackground: Color = Color(0XFFFAF9F9),
    val topBarLineColor: Color = Color(0XFFC2C2C2),
    val buttonRectangleBackground: Color = Color(0XFF342D1A),
    val textColorForTextField: Color = Color(0XFFAF9479),
    val textFieldBackground: Color = Color.White,

)

private val LightColors = Colors()

private val DarkColors = Colors()

val LocalExtendedColors = staticCompositionLocalOf {
    Colors()
}
@Composable
fun TestTaskSWTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (!darkTheme) {
        LightColors
    } else {
        DarkColors
    }

    CompositionLocalProvider(LocalExtendedColors provides colors) {
        MaterialTheme(
            typography = Typography,
            content = content
        )
    }
}
object TestTaskSWTheme {
    val colors: Colors
        @Composable
        get() = LocalExtendedColors.current
}



