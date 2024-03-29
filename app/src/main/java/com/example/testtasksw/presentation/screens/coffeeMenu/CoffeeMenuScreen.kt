package com.example.testtasksw.presentation.screens.coffeeMenu

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.testtasksw.R
import com.example.testtasksw.domain.model.SelectedCoffee
import com.example.testtasksw.presentation.components.ButtonRectangle
import com.example.testtasksw.presentation.ui.theme.TestTaskSWTheme
import com.example.testtasksw.presentation.ui.theme.Typography

@Composable
fun CoffeeMenuScreen(
    onBackCoffeeMenuClick: () -> Unit,
    onCoffeeMenuScreenClick: () -> Unit,
    viewModel: CoffeeMenuViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
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
                            onBackCoffeeMenuClick()
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
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(state.coffeeMenu) { coffeeMenu ->
                    CoffeeMenuItem(
                        coffeeMenu = coffeeMenu,
                        insertSelectedCoffee = { count ->
                            viewModel.insertSelectedCoffee(
                                SelectedCoffee(
                                    id = coffeeMenu.id,
                                    name = coffeeMenu.name,
                                    price = coffeeMenu.price,
                                    count = count
                                )
                            )
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            ButtonRectangle(
                onClick = {
                    onCoffeeMenuScreenClick()
                },
                modifier = Modifier
                    .padding(bottom = 25.dp, start = 15.dp, end = 15.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.go_to_payment),
                    color = TestTaskSWTheme.colors.textColorButton,
                    style = Typography.h3,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        }

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}