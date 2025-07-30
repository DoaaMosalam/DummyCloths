package com.doaa.mosalam.birthdaycard.domain.Repo

import com.doaa.mosalam.birthdaycard.domain.model.products.ProductResponse

interface SearchProductRepo {
    suspend fun searchProducts(query:String): ProductResponse
}