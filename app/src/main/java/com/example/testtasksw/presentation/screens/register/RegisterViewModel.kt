package com.example.testtasksw.presentation.screens.register

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtasksw.common.Resource
import com.example.testtasksw.domain.use_case.GetUserTokenRegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val getUserTokenRegisterUseCase: GetUserTokenRegisterUseCase
) : ViewModel() {

    var textEmail by mutableStateOf("")
    var textPassword by mutableStateOf("")
    var textPasswordRepeat by mutableStateOf("")
    var checkInputData by mutableStateOf(false)

    private val _state = mutableStateOf(RegisterState())
    val state: State<RegisterState> = _state

    private val _tokenState = MutableStateFlow("")
    val tokenState: StateFlow<String> = _tokenState.asStateFlow()

    fun registerUser() {
        viewModelScope.launch {
            getUserTokenRegisterUseCase(textEmail, textPasswordRepeat)
                .onEach { result ->
                    when (result) {
                        is Resource.Loading -> {
                            _state.value = RegisterState(isLoading = true)
                        }

                        is Resource.Error -> {
                            _state.value = RegisterState(
                                error = result.message ?: "An unexpected error occured"
                            )
                        }

                        is Resource.Success -> {
                            _tokenState.value = result.data ?: ""
                            _state.value = RegisterState(
                                isLoading = false
                            )
                        }
                    }
                }.launchIn(this)
        }
    }
}