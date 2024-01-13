package com.example.testtasksw.presentation.screens.login

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtasksw.common.DataStoreManager
import com.example.testtasksw.common.Resource
import com.example.testtasksw.domain.use_case.GetUserTokenLoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val dataStoreManager: DataStoreManager,
    private val getUserTokenLoginUseCase: GetUserTokenLoginUseCase
) : ViewModel() {

    var textEmail by mutableStateOf("")
    var textPassword by mutableStateOf("")
    var checkInputData by mutableStateOf(false)

    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    fun loginUser() {
        viewModelScope.launch {
            getUserTokenLoginUseCase(textEmail, textPassword)
                .onEach { result ->
                    when (result) {
                        is Resource.Loading -> {
                            _state.value = LoginState(
                                isLoading = true
                            )
                        }

                        is Resource.Error -> {
                            _state.value = LoginState(
                                error = result.message ?: "An unexpected error occured"
                            )
                        }

                        is Resource.Success -> {
                            _state.value = LoginState(
                                token = result.data ?: ""
                            )
                            dataStoreManager.setString("token", _state.value.token)
                        }
                    }
                }.launchIn(this)
        }
    }
}