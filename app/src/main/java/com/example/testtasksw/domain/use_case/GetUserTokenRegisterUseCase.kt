package com.example.testtasksw.domain.use_case

import com.example.testtasksw.common.Resource
import com.example.testtasksw.domain.repository.RegisterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetUserTokenRegisterUseCase (
    private val registerRepository: RegisterRepository
) {
     suspend operator fun invoke (email: String, password: String): Flow<Resource<String>> {
        if(email.isBlank() && password.isBlank()) {
            return flow {  }
        }
        return registerRepository.getRegisterUserToken(email, password)
    }
 }