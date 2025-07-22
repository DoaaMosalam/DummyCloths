package com.doaa.mosalam.birthdaycard.Repo

import com.doaa.mosalam.birthdaycard.model.products.ProductResponse

interface ProductSearchRepo {
    suspend fun searchProducts(query:String): ProductResponse
}