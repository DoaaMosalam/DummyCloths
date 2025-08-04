package com.doaa.mosalam.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.google.android.engage.food.datamodel.ProductEntity

@Dao
interface ProductsDao {

    @Query("SELECT * FROM products_table")
    suspend fun getAllProducts(): List<ProductsEntity>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(products: List<ProductsEntity>)

    //search products by name
    @Query("SELECT * FROM products_table WHERE title LIKE '%' || :query || '%'")
    suspend fun searchProducts(query: String): List<ProductsEntity>

    @Query("DELETE FROM products_table")
    suspend fun clearProducts()
}