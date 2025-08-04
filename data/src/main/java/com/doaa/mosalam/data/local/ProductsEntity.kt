package com.doaa.mosalam.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.doaa.mosalam.domain.model.products.Review

@Entity (tableName = "products_table")
data class ProductsEntity(
    @PrimaryKey val id: Int,
    val title: String? = null,
    val brand: String? = null,
    val category: String? = null,
    val description: String? = null,
    val price: Double? = null,
    val discountPercentage: Double? = null,
    val reviews: List<Review>? = null,
    val thumbnail: String? = null,
    val stock: Int? = null,


)
