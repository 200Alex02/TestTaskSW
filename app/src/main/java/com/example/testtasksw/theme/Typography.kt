package com.example.testtasksw.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val nunitoRegular = FontFamily(
    fonts = listOf(
        /*Font(resId = R.font.nunito_regular),
        Font(resId = R.font.nunito_bold, weight = FontWeight.Bold)*/
    )
)

val Typography = Typography(
    h2 = TextStyle(
        fontFamily = nunitoRegular,
        fontSize = 24.sp
    ),
    h3 = TextStyle(
        fontFamily = nunitoRegular,
        fontSize = 18.sp
    ),
    body1 = TextStyle(
        fontFamily = nunitoRegular,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = nunitoRegular,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = nunitoRegular,
        fontSize = 12.sp
    )
)