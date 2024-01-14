package com.example.testtasksw.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.testtasksw.R

private val stUiDisplayRegular = FontFamily(
    fonts = listOf(
        Font(resId = R.font.sf_ui_display_regular),
        Font(resId = R.font.sf_ui_display_bold, weight = FontWeight.Bold)
    )
)

val Typography = Typography(
    h2 = TextStyle(
        fontFamily = stUiDisplayRegular,
        fontSize = 24.sp
    ),
    h3 = TextStyle(
        fontFamily = stUiDisplayRegular,
        fontSize = 18.sp
    ),
    body1 = TextStyle(
        fontFamily = stUiDisplayRegular,
        fontSize = 15.sp
    ),
    body2 = TextStyle(
        fontFamily = stUiDisplayRegular,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = stUiDisplayRegular,
        fontSize = 12.sp
    )
)