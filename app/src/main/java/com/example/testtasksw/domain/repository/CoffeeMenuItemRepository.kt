package com.example.testtasksw.domain.repository

import com.example.testtasksw.common.Resource
import com.example.testtasksw.domain.model.SelectedCoffee
import kotlinx.coroutines.flow.Flow

interface CoffeeMenuItemRepository {

    fun getSelectedCoffee(): Flow<Resource<List<SelectedCoffee>>>

    suspend fun deleteSelectedCoffee(coffeeId: Int)
}