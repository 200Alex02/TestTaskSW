package com.example.testtasksw.presentation.screens.coffeeMenu

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.testtasksw.R
import com.example.testtasksw.domain.model.CoffeeMenu
import com.example.testtasksw.theme.TestTaskSWTheme
import com.example.testtasksw.theme.Typography

@Composable
fun CoffeeMenuItem(
    coffeeMenu: CoffeeMenu,
    count: String
) {
    Card(
        modifier = Modifier
            .padding(all = 10.dp)
            .clickable { },
        elevation = 8.dp,
        backgroundColor = Color.White
    ) {
        Column(
            modifier = Modifier.width(165.dp)
        ) {
            Image(
                modifier = Modifier
                    .height(140.dp)
                    .width(165.dp),
                painter = rememberAsyncImagePainter(coffeeMenu.imageURL),
                contentDescription = "image",
                contentScale = ContentScale.Crop
            )
            Text(
                modifier = Modifier
                    .padding(start = 8.dp, top = 8.dp),
                text = coffeeMenu.name,
                color = TestTaskSWTheme.colors.textColorForTextField,
                style = Typography.body1,
                textAlign = TextAlign.Center,
            )
            Row(
                modifier = Modifier
                    .padding(start = 8.dp, top = 8.dp, bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier,
                    text = coffeeMenu.price,
                    color = TestTaskSWTheme.colors.textColor,
                    style = Typography.body2,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    modifier = Modifier.padding(end = 10.dp),
                    painter = painterResource(id = R.drawable.ic_minus),
                    contentDescription = "icon_minus"
                )
                Text(
                    modifier = Modifier.padding(end = 10.dp),
                    text = count,
                    color = TestTaskSWTheme.colors.textColor,
                    style = Typography.body2,
                    textAlign = TextAlign.Center
                )
                Image(
                    modifier = Modifier.padding(end = 5.dp),
                    painter = painterResource(id = R.drawable.ic_plus),
                    contentDescription = "icon_minus"
                )
            }
        }
    }
}