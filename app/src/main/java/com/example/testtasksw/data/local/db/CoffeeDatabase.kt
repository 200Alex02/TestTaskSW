package com.example.testtasksw.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.testtasksw.data.local.converters.Converters
import com.example.testtasksw.data.local.dao.CoffeeDao
import com.example.testtasksw.data.local.entity.CoffeeMenuEntity
import com.example.testtasksw.data.local.entity.CoffeeShopEntity

@Database(
    entities = [CoffeeMenuEntity::class, CoffeeShopEntity::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class CoffeeDatabase: RoomDatabase() {

    abstract val dao: CoffeeDao
}