package com.example.testtasksw.domain.use_case

import com.example.testtasksw.common.Resource
import com.example.testtasksw.domain.model.SelectedCoffee
import com.example.testtasksw.domain.repository.CoffeeMenuItemRepository
import kotlinx.coroutines.flow.Flow

class GetCoffeeMenuItemByIdUseCase(
    private val repository: CoffeeMenuItemRepository
) {
    fun getSelectedCoffee(): Flow<Resource<List<SelectedCoffee>>> {
        return repository.getSelectedCoffee()
    }

    suspend fun deleteSelectedCoffee(coffeeId: Int) {
        return repository.deleteSelectedCoffee(coffeeId)
    }
}