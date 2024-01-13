package com.example.testtasksw.data.remote.dto

import com.example.testtasksw.data.local.entity.CoffeeShopEntity


data class CoffeeShopDto(
    val id: Int,
    val name: String,
    val point: PointDto
) {
    fun toCoffeeShopEntity(): CoffeeShopEntity {
        return CoffeeShopEntity(
            name = name,
            point = point.toPoint(),
            id = id
        )
    }
}

