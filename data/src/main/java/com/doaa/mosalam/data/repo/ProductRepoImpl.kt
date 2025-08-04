package com.doaa.mosalam.data.repo

import com.doaa.mosalam.data.ApiServer.APIService
import com.doaa.mosalam.data.local.ProductsDao
import com.doaa.mosalam.data.mapper.toDomain
import com.doaa.mosalam.data.mapper.toEntity
import com.doaa.mosalam.domain.Repo.ProductRepo
import com.doaa.mosalam.domain.model.products.ProductResponse
import javax.inject.Inject


class ProductRepoImpl @Inject constructor(
    private val apiService: APIService,
    private val productDao : ProductsDao
) : ProductRepo {
    //    override suspend fun getAllProducts(): ProductResponse {
//        return apiService.getProducts()
//    }

    override suspend fun getAllProducts(): ProductResponse {
        return try {
            // Step 1: get products from API
            val response = apiService.getProducts()

            // Step 2: Convert to Room entities
            val entities = response.products?.mapNotNull { it?.toEntity() } ?: emptyList()

            // Step 3: Save to Room
            productDao.clearProducts()
            productDao.insertAll(entities)

            // Step 4: Return the API response
            response
        } catch (e: Exception) {
            // Step 5: Fallback to local Room data
            val localProducts = productDao.getAllProducts().map { it.toDomain() }
            ProductResponse(products = localProducts)
        }
    }
}