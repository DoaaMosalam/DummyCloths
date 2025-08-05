package com.doaa.mosalam.birthdaycard.common.di

import com.doaa.mosalam.data.ApiServer.APIService
import com.doaa.mosalam.data.local.ProductsDao
import com.doaa.mosalam.data.repo.ProductRepoImpl
import com.doaa.mosalam.data.repo.SearchProductRepoImpl
import com.doaa.mosalam.domain.Repo.ProductRepo
import com.doaa.mosalam.domain.Repo.SearchProductRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @Singleton
    fun provideProductRepo(
        apiService: APIService,
        productDao: ProductsDao
    ): ProductRepo {
        return ProductRepoImpl(apiService, productDao)
    }

    @Provides
    @Singleton
    fun provideSearchProductRepo(
        apiService: APIService
    ): SearchProductRepo {
        return SearchProductRepoImpl(apiService)
    }

}