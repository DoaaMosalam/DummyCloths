package com.doaa.mosalam.birthdaycard.model.products

data class ProductResponse(
    val products: List<ProductsList>?,
    val limit: Int,
    val skip: Int,
    val total: Int

)