package com.example.testtasksw.presentation.screens.order

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.testtasksw.R
import com.example.testtasksw.presentation.components.ButtonRectangle
import com.example.testtasksw.presentation.ui.theme.TestTaskSWTheme
import com.example.testtasksw.presentation.ui.theme.Typography

@Composable
fun CoffeeOrderScreen(
    onBackCoffeeOrderClick: () -> Unit,
    viewModel: CoffeeMenuOrderViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val context = LocalContext.current
    viewModel.getCoffeeMenuItem()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TopAppBar(
                backgroundColor = TestTaskSWTheme.colors.topBarBackground
            ) {
                Image(
                    modifier = Modifier
                        .padding(top = 18.dp, start = 20.dp)
                        .clickable {
                            onBackCoffeeOrderClick()
                        },
                    painter = painterResource(id = R.drawable.ic_arrow_back),
                    contentDescription = "image"
                )
                Text(
                    text = stringResource(id = R.string.menu),
                    color = TestTaskSWTheme.colors.textColor,
                    style = Typography.h3,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                )
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ) {
                items(state.coffeeMenu) { coffeeMenuItem ->
                    CoffeeOrderItem(
                        coffeeMenuItem = coffeeMenuItem,
                        onDeleteClick = { viewModel.deleteSelectedCoffee(coffeeMenuItem.id ?: -1) }
                    )
                }
            }

            if (state.error.isNotEmpty()) {
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

        Text(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 250.dp),
            text = stringResource(id = R.string.finish_order),
            color = TestTaskSWTheme.colors.textColor,
            style = Typography.h2,
            textAlign = TextAlign.Center
        )
        ButtonRectangle(
            onClick = {
                Toast.makeText(context, "Ваш заказ принят!", Toast.LENGTH_SHORT)
                    .show()
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 25.dp, start = 15.dp, end = 15.dp)
        ) {
            Text(
                text = stringResource(id = R.string.payment),
                color = TestTaskSWTheme.colors.textColorButton,
                style = Typography.h3,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}