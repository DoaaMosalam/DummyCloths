package com.doaa.mosalam.data.local

import androidx.room.TypeConverter
import com.doaa.mosalam.domain.model.products.Review
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun fromReviewList(value: List<Review>?): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun toReviewList(value: String): List<Review>? {
        val listType = object : TypeToken<List<Review>>() {}.type
        return Gson().fromJson(value, listType)
    }
}