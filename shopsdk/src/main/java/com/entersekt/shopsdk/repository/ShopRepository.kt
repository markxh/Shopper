package com.entersekt.shopsdk.repository

import android.app.Application
import android.os.AsyncTask
import com.entersekt.shopsdk.data.AppDatabase
import com.entersekt.shopsdk.data.Shop
import com.entersekt.shopsdk.data.ShopDao

class ShopRepository (application: Application) {

    private val shopDao: ShopDao

    init {
        val database: AppDatabase = AppDatabase.getInstance(application.applicationContext)!!
        shopDao = database.shopDao()
    }

    fun getShopsForMall(mallId: Int) = shopDao.getShopsForMall(mallId)

    fun insertShops(shops: List<Shop>) {
        InsertAsyncTask(shopDao).execute(shops)
    }

    private class InsertAsyncTask internal constructor(private val mAsyncTaskDao: ShopDao) :
        AsyncTask<List<Shop>, Void, Void>() {

        override fun doInBackground(vararg params: List<Shop>): Void? {
            mAsyncTaskDao.insertAll(params[0])
            return null
        }
    }

    companion object {

        @Volatile
        private var instance: ShopRepository? = null

        fun getInstance(application: Application) =
            instance ?: synchronized(this) {
                instance ?: ShopRepository(application).also { instance = it }
            }
    }
}