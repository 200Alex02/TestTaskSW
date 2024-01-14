package com.example.testtasksw.presentation.screens.order

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.testtasksw.R
import com.example.testtasksw.domain.model.SelectedCoffee
import com.example.testtasksw.presentation.ui.theme.TestTaskSWTheme
import com.example.testtasksw.presentation.ui.theme.Typography

@Composable
fun CoffeeOrderItem(
    coffeeMenuItem: SelectedCoffee,
    onDeleteClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, top = 5.dp, end = 15.dp)
            .clickable {
                onDeleteClick()
            },
        shape = RoundedCornerShape(5.dp),
        elevation = 8.dp,
        backgroundColor = TestTaskSWTheme.colors.cardBackground
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    text = if (coffeeMenuItem.name.startsWith("https")) "Латте" else coffeeMenuItem.name,
                    color = TestTaskSWTheme.colors.textColor,
                    style = Typography.h3,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = coffeeMenuItem.price,
                    color = TestTaskSWTheme.colors.textColorForTextField,
                    style = Typography.body2,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                modifier = Modifier.padding(end = 10.dp),
                painter = painterResource(id = R.drawable.ic_minus),
                contentDescription = "icon_minus",
                tint = TestTaskSWTheme.colors.textColor
            )
            Text(
                modifier = Modifier.padding(end = 10.dp),
                text = coffeeMenuItem.count.toString(),
                color = TestTaskSWTheme.colors.textColor,
                style = Typography.body2,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_plus),
                contentDescription = "icon_minus",
                tint = TestTaskSWTheme.colors.textColor
            )
        }
    }
}