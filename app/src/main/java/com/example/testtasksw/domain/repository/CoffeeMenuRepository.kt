package com.example.testtasksw.domain.repository

import com.example.testtasksw.common.Resource
import com.example.testtasksw.domain.model.CoffeeMenu
import kotlinx.coroutines.flow.Flow

interface CoffeeMenuRepository {

    fun getCoffeeMenu(id: String, token: String): Flow<Resource<List<CoffeeMenu>>>
}