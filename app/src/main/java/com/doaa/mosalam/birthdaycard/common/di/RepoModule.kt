package com.doaa.mosalam.birthdaycard.common.di

import com.doaa.mosalam.birthdaycard.data.ApiServer.APIService
import com.doaa.mosalam.birthdaycard.data.repo.ProductRepoImpl
import com.doaa.mosalam.birthdaycard.data.repo.SearchProductRepoImpl
import com.doaa.mosalam.birthdaycard.domain.Repo.ProductRepo
import com.doaa.mosalam.birthdaycard.domain.Repo.SearchProductRepo
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
        apiService: APIService
    ): ProductRepo {
        return ProductRepoImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideSearchProductRepo(
        apiService: APIService
    ): SearchProductRepo {
        return SearchProductRepoImpl(apiService)
    }

}