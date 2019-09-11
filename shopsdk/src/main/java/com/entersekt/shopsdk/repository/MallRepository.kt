package com.entersekt.shopsdk.repository

import android.app.Application
import android.os.AsyncTask
import com.entersekt.shopsdk.data.AppDatabase
import com.entersekt.shopsdk.data.Mall
import com.entersekt.shopsdk.data.MallDao

class MallRepository(application: Application){

    private val mallDao: MallDao

    init {
        val database: AppDatabase = AppDatabase.getInstance(application.applicationContext)!!
        mallDao = database.mallDao()
    }

    fun getMallsForCity(cityId: Int) = mallDao.getMallsForCity(cityId)

    fun getMall(mallId: Int) = mallDao.getMall(mallId)

    fun insertMalls(malls: List<Mall>) {
        InsertAsyncTask(mallDao).execute(malls)
    }

    private class InsertAsyncTask internal constructor(private val mAsyncTaskDao: MallDao)
        : AsyncTask<List<Mall>, Void, Void>() {

        override fun doInBackground(vararg params: List<Mall>): Void? {
            mAsyncTaskDao.insertAll(params[0])
            return null
        }
    }

    companion object {

        @Volatile private var instance: MallRepository? = null

        fun getInstance(application: Application) =
            instance ?: synchronized(this) {
                instance ?: MallRepository(application).also { instance = it }
            }
    }
}