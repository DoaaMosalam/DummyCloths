package com.doaa.mosalam.domain.usecase

import com.doaa.mosalam.domain.Repo.ProductRepo
import com.doaa.mosalam.domain.model.products.ProductResponse

class ProductsUseCase(private val productRepo : ProductRepo) {
    suspend fun getAllProducts() : ProductResponse = productRepo.getAllProducts()
}