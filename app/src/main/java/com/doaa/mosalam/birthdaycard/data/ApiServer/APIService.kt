package com.doaa.mosalam.birthdaycard.data.ApiServer

import com.doaa.mosalam.birthdaycard.domain.model.products.ProductResponse

import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    // get products from the API
@GET("products")
suspend fun getProducts(): ProductResponse

//products/search?q=phone'
    @GET("products/search")
    suspend fun searchProducts(@Query("q") query: String): ProductResponse






}