package com.entersekt.shopsdk.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun fromMallsList(value: List<Mall>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Mall>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toMallsList(value: String): List<Mall> {
        val gson = Gson()
        val type = object : TypeToken<List<Mall>>() {}.type
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromShopsList(value: List<Shop>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Shop>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toShopsList(value: String): List<Shop> {
        val gson = Gson()
        val type = object : TypeToken<List<Shop>>() {}.type
        return gson.fromJson(value, type)
    }
}