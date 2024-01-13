package com.example.testtasksw.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testtasksw.data.local.entity.CoffeeMenuEntity
import com.example.testtasksw.data.local.entity.CoffeeShopEntity

@Dao
interface CoffeeDao {

    @Query("SELECT * FROM coffee_shops")
    fun getAllCoffeeShop(): List<CoffeeShopEntity>

    @Query("SELECT * FROM coffee_menu WHERE id = :coffeeShopId")
    fun getMenuForCoffeeShop(coffeeShopId: Int): List<CoffeeMenuEntity>

    @Query("SELECT * FROM coffee_menu WHERE id = :coffeeMenuId")
    fun getCoffeeMenuById(coffeeMenuId: Int): CoffeeMenuEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoffeeShops(coffeeShops: List<CoffeeShopEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoffeeMenu(coffeeMenu: List<CoffeeMenuEntity>)
}