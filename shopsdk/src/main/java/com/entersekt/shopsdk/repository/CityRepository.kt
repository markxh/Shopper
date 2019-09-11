package com.entersekt.shopsdk.repository

import android.app.Application
import android.os.AsyncTask
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.entersekt.shopsdk.api.CitiesResponse
import com.entersekt.shopsdk.data.AppDatabase
import com.entersekt.shopsdk.data.City
import com.entersekt.shopsdk.data.CityDao
import com.entersekt.shopsdk.services.MockyApiService
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Call


class CityRepository(application: Application){

    private val cityDao: CityDao

    private var cities = MutableLiveData<List<City>>()

    private val mockyApiService by lazy {
        MockyApiService.create()
    }

    init {
        val database: AppDatabase = AppDatabase.getInstance(application.applicationContext)!!
        cityDao = database.cityDao()
    }

    fun getCity(cityId: Int) = cityDao.getCity(cityId)

    fun getAllCities(): MutableLiveData<List<City>>? {
        mockyApiService.getAllCities().enqueue(object : Callback<CitiesResponse> {
            override fun onResponse(call: Call<CitiesResponse>, response: Response<CitiesResponse>) {
                cities.value = response.body()?.cities
                InsertAsyncTask(cityDao).execute(response.body()?.cities)
            }

            override fun onFailure(call: Call<CitiesResponse>, t: Throwable) {
                println("error: ${t.localizedMessage}")
            }
        })

        return cities
    }

    private class InsertAsyncTask internal constructor(private val mAsyncTaskDao: CityDao)
        : AsyncTask<List<City>, Void, Void>() {

        override fun doInBackground(vararg params: List<City>): Void? {
            mAsyncTaskDao.insertAll(params[0])
            return null
        }
    }

    companion object {

        @Volatile private var instance: CityRepository? = null

        fun getInstance(application: Application) =
            instance ?: synchronized(this) {
                instance ?: CityRepository(application).also { instance = it }
            }
    }
}