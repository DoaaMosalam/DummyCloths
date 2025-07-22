package com.doaa.mosalam.birthdaycard.Repo

import com.doaa.mosalam.birthdaycard.data.Constant
import com.doaa.mosalam.birthdaycard.model.products.ProductResponse

class ProductRepoImpl : ProductRepo {
    override suspend fun getAllProducts(): ProductResponse {
        return Constant.api.getProducts()
    }


}