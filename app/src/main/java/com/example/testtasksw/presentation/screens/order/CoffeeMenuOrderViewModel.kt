package com.example.testtasksw.presentation.screens.order

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtasksw.common.Resource
import com.example.testtasksw.domain.use_case.GetCoffeeMenuItemByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoffeeMenuOrderViewModel @Inject constructor(
    private val getCoffeeMenuItemByIdUseCase: GetCoffeeMenuItemByIdUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(CoffeeMenuItemState())
    val state: State<CoffeeMenuItemState> = _state

    fun getCoffeeMenuItem() {
        viewModelScope.launch(Dispatchers.IO) {
            getCoffeeMenuItemByIdUseCase.getSelectedCoffee()
                .onEach { result ->
                    when (result) {

                        is Resource.Loading -> {
                            viewModelScope.launch(Dispatchers.Main) {
                                _state.value = CoffeeMenuItemState(
                                    isLoading = true
                                )
                            }
                        }

                        is Resource.Error -> {
                            viewModelScope.launch(Dispatchers.Main) {
                                _state.value = CoffeeMenuItemState(
                                    error = result.message
                                        ?: "Failed to retrieve coffee menu item from database"
                                )
                            }
                        }

                        is Resource.Success -> {
                            viewModelScope.launch(Dispatchers.Main) {
                                _state.value = CoffeeMenuItemState(
                                    coffeeMenu = result.data ?: emptyList(),
                                    isLoading = false
                                )
                            }
                        }
                    }
                }.launchIn(this)
        }
    }

    fun deleteSelectedCoffee(coffeeId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            getCoffeeMenuItemByIdUseCase.deleteSelectedCoffee(coffeeId)
        }
        getCoffeeMenuItem()
    }
}