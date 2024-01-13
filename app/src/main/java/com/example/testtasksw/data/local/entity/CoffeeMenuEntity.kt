package com.example.testtasksw.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testtasksw.domain.model.CoffeeMenu

@Entity(tableName = "coffee_menu")
data class CoffeeMenuEntity(
    val name: String,
    val imageURL: String,
    val price: String,
    @PrimaryKey val id: Int? = null
) {
    fun toCoffeeMenu(): CoffeeMenu {
        return CoffeeMenu(
            id = id,
            name = name,
            imageURL = imageURL,
            price = price
        )
    }
}
