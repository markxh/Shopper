package com.entersekt.shopper.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.entersekt.shopsdk.data.City
import com.entersekt.shopsdk.data.Mall
import com.entersekt.shopsdk.repository.CityRepository

class CitiesViewModel : ViewModel() {

    val cityRepository = CityRepository()
    val cities: LiveData<List<City>> get() = cityRepository.getAllCities()
}