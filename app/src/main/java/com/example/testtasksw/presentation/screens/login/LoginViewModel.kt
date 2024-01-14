package com.example.testtasksw.presentation.screens.login

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtasksw.common.Constant
import com.example.testtasksw.common.DataStoreManager
import com.example.testtasksw.common.Resource
import com.example.testtasksw.domain.use_case.GetUserTokenLoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
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

    private val _tokenState = MutableStateFlow("")
    val tokenState: StateFlow<String> = _tokenState.asStateFlow()

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
                            _tokenState.value = result.data ?: ""
                            _state.value = LoginState(
                                token = result.data ?: "",
                                isLoading = false
                            )
                            dataStoreManager.setString(Constant.TOKEN_KEY, _state.value.token)
                            Log.d("tag6", _state.value.token)
                        }
                    }
                }.launchIn(this)
        }
    }
}