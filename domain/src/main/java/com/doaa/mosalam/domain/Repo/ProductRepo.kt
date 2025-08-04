package com.doaa.mosalam.domain.Repo

import com.doaa.mosalam.domain.model.products.ProductResponse

interface ProductRepo {
    suspend fun getAllProducts(): ProductResponse
}