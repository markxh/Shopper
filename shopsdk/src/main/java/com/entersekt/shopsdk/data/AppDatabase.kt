package com.entersekt.shopsdk.data

import android.content.Context
import androidx.room.*
import com.entersekt.shopsdk.utilities.DATABASE_NAME

@Database(entities = [City::class, Mall::class, Shop::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cityDao(): CityDao
    abstract fun mallDao(): MallDao
    abstract fun shopDao(): ShopDao

    companion object {
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {
                synchronized(AppDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, DATABASE_NAME
                    ).build()
                }
            }
            return instance
        }
    }
}