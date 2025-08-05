package com.doaa.mosalam.birthdaycard.common.di

import android.app.Application
import androidx.room.Room
import com.doaa.mosalam.birthdaycard.common.Constant
import com.doaa.mosalam.data.AppDatabase
import com.doaa.mosalam.data.local.ProductsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkRoomDataModule {
    @Provides
    @Singleton
    fun provideAppDatabaseBuilder(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            Constant.DATABASE_NAME
        )
            .addMigrations(
                AppDatabase.MIGRATION_1_2,
                AppDatabase.MIGRATION_2_3,
                AppDatabase.MIGRATION_3_4,
                AppDatabase.MIGRATION_4_5
            )
            .fallbackToDestructiveMigration() // This will destroy and recreate the database
            .build()
    }

    @Provides
    @Singleton
    fun provideProductsDao(db: AppDatabase): ProductsDao = db.productsDao()


}