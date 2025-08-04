package com.doaa.mosalam.domain.Repo

import com.doaa.mosalam.domain.model.products.ProductResponse

interface SearchProductRepo {
    suspend fun searchProducts(query: String): ProductResponse
}