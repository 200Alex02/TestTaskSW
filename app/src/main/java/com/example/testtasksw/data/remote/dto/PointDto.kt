package com.example.testtasksw.data.remote.dto

import com.example.testtasksw.domain.model.Point

data class PointDto(
    val latitude: String,
    val longitude: String
) {
    fun toPoint(): Point {
        return Point(
            latitude = latitude,
            longitude = longitude
        )
    }
}
