package com.doaa.mosalam.domain.usecase

import com.doaa.mosalam.domain.Repo.SearchProductRepo
import com.doaa.mosalam.domain.model.products.ProductResponse

class SearchUseCase(private val searchProductRepo: SearchProductRepo){
    suspend fun searchProducts(query: String): ProductResponse = searchProductRepo.searchProducts(query)
}