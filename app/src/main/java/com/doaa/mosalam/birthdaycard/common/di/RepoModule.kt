package com.doaa.mosalam.birthdaycard.common.di

import com.doaa.mosalam.birthdaycard.domain.Repo.ProductRepo
import com.doaa.mosalam.birthdaycard.data.repo.ProductRepoImpl
import com.doaa.mosalam.birthdaycard.data.repo.SearchProductRepoImpl
import com.doaa.mosalam.birthdaycard.data.ApiServer.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {

    @Provides
    @ActivityScoped
    fun provideProductRepo(
        apiService: APIService
    ): ProductRepo{
        return ProductRepoImpl(apiService)
    }
    @Provides
    @Singleton
    fun provideSearchProductRepo(
        apiService: APIService
    ): SearchProductRepoImpl {
        return SearchProductRepoImpl(apiService)
    }

}