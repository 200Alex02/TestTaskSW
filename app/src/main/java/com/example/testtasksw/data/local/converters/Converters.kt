package com.example.testtasksw.data.local.converters

import androidx.room.TypeConverter
import com.example.testtasksw.domain.model.Point
import com.google.gson.Gson

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromPoint(point: Point): String {
        return gson.toJson(point)
    }

    @TypeConverter
    fun toPoint(pointString: String): Point {
        return gson.fromJson(pointString, Point::class.java)
    }
}