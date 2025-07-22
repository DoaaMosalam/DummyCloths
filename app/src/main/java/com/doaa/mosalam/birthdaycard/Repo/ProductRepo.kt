package com.doaa.mosalam.birthdaycard.Repo

import com.doaa.mosalam.birthdaycard.model.products.ProductResponse

interface ProductRepo {
    suspend fun getAllProducts(): ProductResponse
}