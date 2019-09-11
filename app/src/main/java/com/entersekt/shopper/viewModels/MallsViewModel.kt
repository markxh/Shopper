package com.entersekt.shopper.viewModels

import android.app.Application
import androidx.lifecycle.*
import com.entersekt.shopsdk.data.City
import com.entersekt.shopsdk.data.Mall
import com.entersekt.shopsdk.repository.CityRepository
import com.entersekt.shopsdk.repository.MallRepository

class MallsViewModel (application: Application, cityId: Int): AndroidViewModel(application) {

    private val cityRepository: CityRepository
    private val mallRepository: MallRepository

    var city: LiveData<City>?

    init {
        cityRepository = CityRepository.getInstance(application)
        mallRepository = MallRepository.getInstance(application)

        city = cityRepository.getCity(cityId)
    }

    //This would come from api call
    fun saveMalls(malls: List<Mall>) {
        mallRepository.insertMalls(malls)
    }
}