package com.example.testtasksw.presentation.screens.coffeeShops

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtasksw.common.Constant
import com.example.testtasksw.common.DataStoreManager
import com.example.testtasksw.common.Resource
import com.example.testtasksw.domain.use_case.GetCoffeeShopsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoffeeShopsViewModel @Inject constructor(
    private val coffeeShopsUseCase: GetCoffeeShopsUseCase,
    private val dataStoreManager: DataStoreManager
) : ViewModel() {

    private val _state = mutableStateOf(CoffeeShopsState())
    val state: State<CoffeeShopsState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val token = dataStoreManager.getString(Constant.TOKEN_KEY)
            coffeeShopsUseCase(token)
                .onEach { result ->
                    when (result) {
                        is Resource.Loading -> {
                            viewModelScope.launch(Dispatchers.Main) {
                                _state.value = state.value.copy(
                                    coffeeShops = result.data ?: emptyList(),
                                    isLoading = true
                                )
                            }
                        }

                        is Resource.Error -> {
                            viewModelScope.launch(Dispatchers.Main) {
                                _state.value = state.value.copy(
                                    coffeeShops = result.data ?: emptyList(),
                                    error = result.message ?: "An unexpected error occured"
                                )
                            }
                        }

                        is Resource.Success -> {
                            viewModelScope.launch(Dispatchers.Main) {
                                _state.value = state.value.copy(
                                    coffeeShops = result.data ?: emptyList(),
                                    isLoading = false
                                )
                            }
                        }
                    }
                }.launchIn(this)
        }
    }
}