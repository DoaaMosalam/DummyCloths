package com.doaa.mosalam.birthdaycard.domain.model.products

data class ProductResponse(
    val products: List<ProductsList?>? = null,
    val limit: Int? = null,
    val skip: Int? = null,
    val total: Int? = null
)