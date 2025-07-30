package com.doaa.mosalam.birthdaycard.data.repo

import com.doaa.mosalam.birthdaycard.domain.Repo.SearchProductRepo
import com.doaa.mosalam.birthdaycard.data.ApiServer.APIService
import com.doaa.mosalam.birthdaycard.domain.model.products.ProductResponse
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject
class SearchProductRepoImpl @Inject constructor(
    private val api: APIService
): SearchProductRepo {
    override suspend fun searchProducts(query: String): ProductResponse {
       return api.searchProducts(query)
    }
}