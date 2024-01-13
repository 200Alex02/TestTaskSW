package com.example.testtasksw.data.remote.api

import com.example.testtasksw.data.remote.dto.CoffeeShopDto
import com.example.testtasksw.data.remote.dto.CoffeeMenuDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @POST("/auth/register")
    suspend fun getRegisterToken(
        @Query("login") login: String,
        @Query("password") password: String
    ): String

    @POST("/auth/login")
    suspend fun getLoginToken(
        @Query("login") login: String,
        @Query("password") password: String
    ): String

    @GET("/locations")
    suspend fun getCoffeeShops(@Header("Authorization") token: String): List<CoffeeShopDto>


    @GET("/location/{id}/menu")
    suspend fun getMenuById(
        @Path("id") id: String,
        @Header("Authorization") token: String
    ): List<CoffeeMenuDto>
}