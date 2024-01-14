package com.example.testtasksw.data.repository

import com.example.testtasksw.common.Resource
import com.example.testtasksw.data.local.dao.CoffeeDao
import com.example.testtasksw.data.remote.api.ApiService
import com.example.testtasksw.domain.model.CoffeeMenu
import com.example.testtasksw.domain.model.SelectedCoffee
import com.example.testtasksw.domain.repository.CoffeeMenuRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class CoffeeMenuRepositoryImpl(
    private val api: ApiService,
    private val dao: CoffeeDao
) : CoffeeMenuRepository {
    override fun getCoffeeMenu(id: String, token: String): Flow<Resource<List<CoffeeMenu>>> = flow {
        emit(Resource.Loading())

        val coffeeMenu = dao.getMenuForCoffeeShop().map { it.toCoffeeMenu() }
        emit(Resource.Loading(data = coffeeMenu))

        try {
            val remoteCoffeeShopMenu = api.getMenuById(id, "Bearer $token")
            dao.deleteAllCoffeeMenu()
            dao.insertCoffeeMenu(remoteCoffeeShopMenu.map { it.toCoffeeMenuEntity() })
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = "Oops, something went wrong!",
                    data = coffeeMenu
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Couldn't reach server, check your internet connection.",
                    data = coffeeMenu
                )
            )
        }

        val newCoffeeShopMenu = dao.getMenuForCoffeeShop().map { it.toCoffeeMenu() }
        emit(Resource.Success(newCoffeeShopMenu))
    }

    override suspend fun insertSelectedCoffee(selectedCoffee: SelectedCoffee) {
        dao.insertSelectedProduct(selectedCoffee.toSelectedCoffeeEntity())
    }
}