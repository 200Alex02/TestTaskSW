package com.example.testtasksw.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testtasksw.domain.model.CoffeeShop
import com.example.testtasksw.domain.model.Point

@Entity(tableName = "coffee_shops")
data class CoffeeShopEntity (
    val name: String,
    val point: Point,
    @PrimaryKey val id: Int? = null
) {
    fun toCoffeeShop(): CoffeeShop {
        return CoffeeShop(
            id = id,
            name = name,
            point = point
        )
    }
}