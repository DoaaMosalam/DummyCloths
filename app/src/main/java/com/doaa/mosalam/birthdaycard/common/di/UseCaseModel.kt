package com.doaa.mosalam.birthdaycard.common.di

import com.doaa.mosalam.domain.Repo.ProductRepo
import com.doaa.mosalam.domain.Repo.SearchProductRepo
import com.doaa.mosalam.domain.usecase.ProductsUseCase
import com.doaa.mosalam.domain.usecase.SearchUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModel {

 @Provides
    @Singleton
    fun provideProductsUseCase(
        productRepo: ProductRepo
    ): ProductsUseCase {
        return ProductsUseCase(productRepo)
    }

    @Provides
    @Singleton
    fun provideSearchProductUseCase(
        searchProductRepo: SearchProductRepo
    ): SearchUseCase {
        return SearchUseCase(searchProductRepo)
    }


}