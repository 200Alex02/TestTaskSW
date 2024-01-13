package com.example.testtasksw.data.repository

import com.example.testtasksw.common.Resource
import com.example.testtasksw.data.remote.api.ApiService
import com.example.testtasksw.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class LoginRepositoryImpl(
    private val api: ApiService
) : LoginRepository {
    override suspend fun getLoginUserToken(
        email: String,
        password: String
    ): Flow<Resource<String>> = flow {
        try {
            emit(Resource.Loading())
            val loginToken = api.getLoginToken(email, password)
            emit(Resource.Success(loginToken))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}