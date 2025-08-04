package com.doaa.mosalam.domain.model.products

data class ProductsList(
    val id: Int? = null,
    val title: String? = null,
    val brand: String? = null,
    val category: String? = null,
    val description: String? = null,
    val price: Double? = null,
    val discountPercentage: Double? = null,
    val images: List<String>? = null,
    val rating: Double? = null,
    val reviews: List<Review>? = null,
    val thumbnail: String? = null,
    val stock: Int? = null,
)