package com.example.testtasksw.domain.model

import com.example.testtasksw.data.local.entity.SelectedCoffeeEntity

data class SelectedCoffee(
    val id: Int?,
    val name: String,
    val price: String,
    val count: Int
) {
    fun toSelectedCoffeeEntity(): SelectedCoffeeEntity {
        return SelectedCoffeeEntity(
            name = name,
            price = price,
            count = count,
            id = id
        )
    }
}
