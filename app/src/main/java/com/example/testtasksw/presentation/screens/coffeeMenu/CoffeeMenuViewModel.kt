package com.example.testtasksw.presentation.screens.coffeeMenu

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtasksw.common.Constant.GAME_ID_KEY
import com.example.testtasksw.common.Constant.TOKEN_KEY
import com.example.testtasksw.common.DataStoreManager
import com.example.testtasksw.common.Resource
import com.example.testtasksw.domain.use_case.GetCoffeeMenuUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoffeeMenuViewModel @Inject constructor(
    private val coffeeMenuUseCase: GetCoffeeMenuUseCase,
    private val dataStoreManager: DataStoreManager,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoffeeMenuState())
    val state: State<CoffeeMenuState> = _state

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val token = dataStoreManager.getString(TOKEN_KEY)
            val id = savedStateHandle.get<String>(key = GAME_ID_KEY)

            coffeeMenuUseCase(id.toString(), token)
                .onEach { result ->
                    when (result) {
                        is Resource.Loading -> {
                            viewModelScope.launch(Dispatchers.Main) {
                                _state.value = state.value.copy(
                                    coffeeMenu = result.data ?: emptyList(),
                                    isLoading = true
                                )
                            }
                        }

                        is Resource.Error -> {
                            viewModelScope.launch(Dispatchers.Main) {
                                _state.value = state.value.copy(
                                    coffeeMenu = result.data ?: emptyList(),
                                    error = result.message ?: "An unexpected error occured"
                                )
                            }
                        }

                        is Resource.Success -> {
                            viewModelScope.launch(Dispatchers.Main) {
                                _state.value = state.value.copy(
                                    coffeeMenu = result.data ?: emptyList(),
                                    isLoading = false
                                )
                            }
                        }
                    }
                }.launchIn(this)
        }
    }
}