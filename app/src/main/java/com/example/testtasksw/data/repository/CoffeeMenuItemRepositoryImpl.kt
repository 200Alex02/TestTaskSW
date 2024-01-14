package com.example.testtasksw.data.repository

import com.example.testtasksw.common.Resource
import com.example.testtasksw.data.local.dao.CoffeeDao
import com.example.testtasksw.domain.model.SelectedCoffee
import com.example.testtasksw.domain.repository.CoffeeMenuItemRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CoffeeMenuItemRepositoryImpl(
    private val dao: CoffeeDao
) : CoffeeMenuItemRepository {

    override fun getSelectedCoffee(): Flow<Resource<List<SelectedCoffee>>> = flow {
        try {
            emit(Resource.Loading())
            val selectedCoffee = dao.getSelectedProducts().map { it.toSelectedCoffee() }
            emit(Resource.Success(selectedCoffee))
        } catch (e: Exception) {
            emit(Resource.Error(message = "Failed to retrieve coffee menu item from database"))
        }
    }

    override suspend fun deleteSelectedCoffee(coffeeId: Int) {
        dao.deleteSelectedCoffee(coffeeId)
    }
}