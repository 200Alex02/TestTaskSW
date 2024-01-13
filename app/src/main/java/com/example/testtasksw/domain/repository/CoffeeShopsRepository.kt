package com.example.testtasksw.domain.repository

import com.example.testtasksw.common.Resource
import com.example.testtasksw.domain.model.CoffeeShop
import kotlinx.coroutines.flow.Flow

interface CoffeeShopsRepository {

    fun getCoffeeShops(token: String): Flow<Resource<List<CoffeeShop>>>
}