package com.example.testtasksw.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testtasksw.domain.model.SelectedCoffee

@Entity(tableName = "selected_products")
data class SelectedCoffeeEntity(
    val name: String,
    val price: String,
    val count: Int,
    @PrimaryKey val id: Int? = null
) {
    fun toSelectedCoffee(): SelectedCoffee {
        return SelectedCoffee(
            id = id,
            name = name,
            price = price,
            count = count
        )
    }
}
