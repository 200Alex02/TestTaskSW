package com.example.testtasksw.domain.use_case

import com.example.testtasksw.common.Resource
import com.example.testtasksw.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetUserTokenLoginUseCase(
    private val loginRepository: LoginRepository
) {

    suspend operator fun invoke(email: String, password: String): Flow<Resource<String>> {
        if (email.isBlank() && password.isBlank()) {
            return flow { }
        }
        return loginRepository.getLoginUserToken(email, password)
    }
}