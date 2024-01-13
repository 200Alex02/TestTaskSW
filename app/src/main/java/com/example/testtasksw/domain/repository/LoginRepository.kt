package com.example.testtasksw.domain.repository

import com.example.testtasksw.common.Resource
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    suspend fun getLoginUserToken(email: String, password: String): Flow<Resource<String>>
}