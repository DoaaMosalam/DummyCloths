package com.doaa.mosalam.data.repo

import com.doaa.mosalam.data.ApiServer.APIService
import com.doaa.mosalam.domain.Repo.SearchProductRepo
import com.doaa.mosalam.domain.model.products.ProductResponse
import javax.inject.Inject

class SearchProductRepoImpl @Inject constructor(
    private val api: APIService
) : SearchProductRepo {
//    override suspend fun searchProducts(query: String): ProductResponse {
//        return api.searchProducts(query)
//    }
    override suspend fun searchProducts(query: String): ProductResponse {
        return try {
            // Step 1: get products from API
            api.searchProducts(query)
        } catch (e: Exception) {
            // Handle the exception (e.g., log it, rethrow it, etc.)
            // For now, we can just return an empty response or handle it as needed
            ProductResponse(products = emptyList())
        }
    }
}