package com.example.testtasksw.data.remote.api

import com.example.testtasksw.data.remote.dto.CoffeeShopDto
import com.example.testtasksw.data.remote.dto.CoffeeMenuDto
import com.example.testtasksw.data.remote.model.LoginRequest
import com.example.testtasksw.data.remote.model.LoginResponse
import com.example.testtasksw.data.remote.model.RegisterRequest
import com.example.testtasksw.data.remote.model.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @POST("/auth/register")
    suspend fun getRegisterToken(
        @Body registerRequest: RegisterRequest,
    ): RegisterResponse

    @POST("/auth/login")
    suspend fun getLoginToken(
        @Body loginRequest: LoginRequest
    ): LoginResponse

    @GET("/locations")
    suspend fun getCoffeeShops(@Header("Authorization") token: String): List<CoffeeShopDto>


    @GET("/location/{id}/menu")
    suspend fun getMenuById(
        @Path("id") id: String,
        @Header("Authorization") token: String
    ): List<CoffeeMenuDto>
}