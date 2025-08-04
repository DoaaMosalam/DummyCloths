package com.doaa.mosalam.data.mapper

import com.doaa.mosalam.data.local.ProductsEntity
import com.doaa.mosalam.domain.model.products.ProductsList
// ProductsList → ProductsEntity
fun ProductsList.toEntity(): ProductsEntity{
    return ProductsEntity(
        id = this.id ?: 0,
        title = this.title,
        brand = this.brand,
        category = this.category,
        description = this.description,
        price = this.price,
        discountPercentage = this.discountPercentage,
        reviews = this.reviews,
        thumbnail = this.thumbnail,
        stock = this.stock
    )
}

// ProductsEntity → ProductsList
fun ProductsEntity.toDomain(): ProductsList {
    return ProductsList(
        id = this.id,
        title = this.title,
        brand = this.brand,
        category = this.category,
        description = this.description,
        price = this.price,
        discountPercentage = this.discountPercentage,
        reviews = this.reviews,
        thumbnail = this.thumbnail,
        stock = this.stock
    )
}