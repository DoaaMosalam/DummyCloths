package com.doaa.mosalam.birthdaycard.data.repo

import com.doaa.mosalam.birthdaycard.domain.Repo.ProductRepo
import com.doaa.mosalam.birthdaycard.data.ApiServer.APIService
import com.doaa.mosalam.birthdaycard.domain.model.products.ProductResponse
import jakarta.inject.Inject


class ProductRepoImpl @Inject constructor(
    private val apiService : APIService
) : ProductRepo {
    override suspend fun getAllProducts(): ProductResponse {
        return  apiService.getProducts()
    }
}