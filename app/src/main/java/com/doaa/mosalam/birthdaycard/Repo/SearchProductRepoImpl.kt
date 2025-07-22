package com.doaa.mosalam.birthdaycard.Repo

import com.doaa.mosalam.birthdaycard.data.ApiServer.APIService
import com.doaa.mosalam.birthdaycard.data.Constant
import com.doaa.mosalam.birthdaycard.model.products.ProductResponse

class SearchProductRepoImpl(
//    private val api: APIService
): ProductSearchRepo {
    override suspend fun searchProducts(query: String): ProductResponse {
//       return api.searchProducts(query)
        return Constant.api.searchProducts(query)
    }
}