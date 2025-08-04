package com.doaa.mosalam.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.doaa.mosalam.data.local.Converters
import com.doaa.mosalam.data.local.ProductsDao
import com.doaa.mosalam.data.local.ProductsEntity

@Database(entities = [
            ProductsEntity::class],
        version = 1,
        exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase(){
    abstract fun productsDao(): ProductsDao

    companion object {
        // Add any migrations here if needed in the future
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Schema changes from version 1 to 2
            }
        }

        val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Create image_user table
                database.execSQL(
                    "CREATE TABLE image_user (" +
                            "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                            "imageUri TEXT NOT NULL)"
                )
            }
        }

        val MIGRATION_3_4 = object : Migration(3, 4) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Example of adding a column
                database.execSQL("ALTER TABLE image_user ADD COLUMN new_column_name TEXT")
            }
        }

        val MIGRATION_4_5 = object : Migration(4, 5) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Handle any schema changes for version 5
            }
        }

    }
}