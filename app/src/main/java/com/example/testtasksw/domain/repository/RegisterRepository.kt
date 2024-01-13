package com.example.testtasksw.domain.repository

import com.example.testtasksw.common.Resource
import kotlinx.coroutines.flow.Flow

interface RegisterRepository {

    suspend fun getRegisterUserToken(email: String, password: String): Flow<Resource<String>>
}