package com.example.testtasksw.presentation.screens.coffeeShops

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.testtasksw.theme.TestTaskSWTheme
import com.example.testtasksw.theme.Typography

@Composable
fun CoffeeShopItem(
    coffeeShopName: String,
    distance: String = "",
    onCoffeeShopClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, top = 5.dp, end = 15.dp)
            .clickable {
                onCoffeeShopClick()
            },
        shape = RoundedCornerShape(5.dp),
        elevation = 5.dp,
        backgroundColor = TestTaskSWTheme.colors.cardBackground
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(
                text = coffeeShopName,
                color = TestTaskSWTheme.colors.textColor,
                style = Typography.h3,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = distance,
                color = TestTaskSWTheme.colors.textColor,
                style = Typography.body2,
                textAlign = TextAlign.Center
            )
        }
    }
}