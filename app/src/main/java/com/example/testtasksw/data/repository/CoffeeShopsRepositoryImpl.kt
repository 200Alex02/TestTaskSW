package com.example.testtasksw.data.repository

import com.example.testtasksw.common.Resource
import com.example.testtasksw.data.local.dao.CoffeeDao
import com.example.testtasksw.data.remote.api.ApiService
import com.example.testtasksw.domain.model.CoffeeShop
import com.example.testtasksw.domain.repository.CoffeeShopsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class CoffeeShopsRepositoryImpl(
    private val api: ApiService,
    private val dao: CoffeeDao
) : CoffeeShopsRepository {
    override fun getCoffeeShops(token: String): Flow<Resource<List<CoffeeShop>>> = flow {
        emit(Resource.Loading())

        val coffeeShops = dao.getAllCoffeeShop().map { it.toCoffeeShop() }
        emit(Resource.Loading(data = coffeeShops))

        try {
            val remoteCoffeeShops = api.getCoffeeShops("Bearer $token")
            dao.insertCoffeeShops(remoteCoffeeShops.map { it.toCoffeeShopEntity() })
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = "Oops, something went wrong!",
                    data = coffeeShops
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Couldn't reach server, check your internet connection.",
                    data = coffeeShops
                )
            )
        }

        val newCoffeeShops = dao.getAllCoffeeShop().map { it.toCoffeeShop() }
        emit(Resource.Success(newCoffeeShops))
    }
}