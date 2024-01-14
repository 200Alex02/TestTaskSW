package com.example.testtasksw.domain.use_case

import com.example.testtasksw.common.Resource
import com.example.testtasksw.domain.model.CoffeeMenu
import com.example.testtasksw.domain.model.SelectedCoffee
import com.example.testtasksw.domain.repository.CoffeeMenuRepository
import kotlinx.coroutines.flow.Flow

class GetCoffeeMenuUseCase(
    private val repository: CoffeeMenuRepository
) {
    operator fun invoke(id: String, token: String): Flow<Resource<List<CoffeeMenu>>> {
        return repository.getCoffeeMenu(id, token)
    }

    suspend fun insertSelectedCoffee(selectedCoffee: SelectedCoffee) {
        return repository.insertSelectedCoffee(selectedCoffee)
    }
}