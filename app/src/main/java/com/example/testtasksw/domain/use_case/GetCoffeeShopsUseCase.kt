package com.example.testtasksw.domain.use_case

import com.example.testtasksw.common.Resource
import com.example.testtasksw.domain.model.CoffeeShop
import com.example.testtasksw.domain.repository.CoffeeShopsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCoffeeShopsUseCase(
    private val repository: CoffeeShopsRepository
) {

    operator fun invoke(token: String): Flow<Resource<List<CoffeeShop>>> {
        if (token.isBlank()) {
            return flow {  }
        }
        return repository.getCoffeeShops(token)
    }
}