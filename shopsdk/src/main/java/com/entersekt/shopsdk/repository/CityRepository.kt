package com.entersekt.shopsdk.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.entersekt.shopsdk.api.CitiesResponse
import com.entersekt.shopsdk.data.City
import com.entersekt.shopsdk.services.MockyApiService
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Call


class CityRepository {

    private var cities = MutableLiveData<List<City>>()

    private val mockyApiService by lazy {
        MockyApiService.create()
    }

    fun getAllCities(): MutableLiveData<List<City>> {
        mockyApiService.getAllCities().enqueue(object : Callback<CitiesResponse> {
            override fun onResponse(call: Call<CitiesResponse>, response: Response<CitiesResponse>) {
                cities.value = response.body()?.cities
            }

            override fun onFailure(call: Call<CitiesResponse>, t: Throwable) {
                println("error: ${t.localizedMessage}")
            }
        })

        return cities
    }
}