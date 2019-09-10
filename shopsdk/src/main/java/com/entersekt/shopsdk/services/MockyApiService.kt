package com.entersekt.shopsdk.services

import com.entersekt.shopsdk.api.CitiesResponse
import com.entersekt.shopsdk.data.City
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface MockyApiService {

    @GET("5b7e8bc03000005c0084c210")
    fun getAllCities(): Call<CitiesResponse>

    companion object {

        fun create(): MockyApiService {

            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build()

            return Retrofit.Builder()
                .baseUrl("http://www.mocky.io/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(MockyApiService::class.java)
        }
    }
}