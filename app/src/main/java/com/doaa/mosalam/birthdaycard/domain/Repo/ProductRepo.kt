package com.doaa.mosalam.birthdaycard.domain.Repo

import com.doaa.mosalam.birthdaycard.domain.model.products.ProductResponse

interface ProductRepo {
    suspend fun getAllProducts(): ProductResponse
}