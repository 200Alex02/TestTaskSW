package com.example.testtasksw.data.remote.dto

import com.example.testtasksw.data.local.entity.CoffeeMenuEntity

data class CoffeeMenuDto(
    val id: Int,
    val name: String,
    val imageURL: String,
    val price: String
) {
    fun toCoffeeMenuEntity(): CoffeeMenuEntity{
        return CoffeeMenuEntity(
            name = name,
            imageURL = imageURL,
            price = price,
            id = id
        )
    }
}
