package com.example.testtasksw.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testtasksw.data.local.entity.CoffeeMenuEntity
import com.example.testtasksw.data.local.entity.CoffeeShopEntity
import com.example.testtasksw.data.local.entity.SelectedCoffeeEntity

@Dao
interface CoffeeDao {

    @Query("SELECT * FROM coffee_shops")
    fun getAllCoffeeShop(): List<CoffeeShopEntity>

    @Query("SELECT * FROM coffee_menu")
    fun getMenuForCoffeeShop(): List<CoffeeMenuEntity>

    @Query("DELETE FROM coffee_menu")
    fun deleteAllCoffeeMenu()

    @Query("SELECT * FROM coffee_menu WHERE id = :coffeeMenuId")
    fun getCoffeeMenuById(coffeeMenuId: Int): List<CoffeeMenuEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoffeeShops(coffeeShops: List<CoffeeShopEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoffeeMenu(coffeeMenu: List<CoffeeMenuEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSelectedProduct(selectedProduct: SelectedCoffeeEntity)

    @Query("SELECT * FROM selected_products")
    fun getSelectedProducts(): List<SelectedCoffeeEntity>

    @Query("DELETE FROM selected_products WHERE id = :coffeeId")
    suspend fun deleteSelectedCoffee(coffeeId: Int)
}