package com.doaa.mosalam.birthdaycard.data

import com.doaa.mosalam.birthdaycard.data.ApiServer.APIService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Constant {

    //'https://dummyjson.com/products'
    const val BASEURL ="https://dummyjson.com/"

    val api: APIService by lazy {
        Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)
    }
}