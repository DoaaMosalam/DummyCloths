package com.doaa.mosalam.birthdaycard.model.products

import com.doaa.mosalam.birthdaycard.model.products.Review

data class ProductsList(
    val id: Int,
    val title: String,
    val brand: String,
    val category: String,
    val description: String,
    val price: Double,
    val discountPercentage: Double,
    val images: List<String>,
    val rating: Double,
    val reviews: List<Review>,
    val thumbnail: String,
    val stock: Int,
)