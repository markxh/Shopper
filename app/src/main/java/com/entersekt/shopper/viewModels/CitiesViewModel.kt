package com.entersekt.shopper.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.entersekt.shopsdk.data.City
import com.entersekt.shopsdk.repository.CityRepository

class CitiesViewModel(application: Application): AndroidViewModel(application) {

    private val cityRepository: CityRepository

    internal val cities: LiveData<List<City>>

    init {
        cityRepository = CityRepository.getInstance(application)
        cities = cityRepository.getAllCities()!!
    }
}