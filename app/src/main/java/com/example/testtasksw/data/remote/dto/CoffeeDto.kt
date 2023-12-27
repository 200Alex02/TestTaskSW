package com.example.testtasksw.data.remote.dto

data class CoffeeDto(
    val id: Int,
    val name: String,
    val point: Point
)

data class Point(
    val latitude: String,
    val longitude: String
)
