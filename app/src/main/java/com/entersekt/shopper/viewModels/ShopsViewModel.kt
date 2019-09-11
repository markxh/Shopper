package com.entersekt.shopper.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.entersekt.shopsdk.data.Mall
import com.entersekt.shopsdk.data.Shop
import com.entersekt.shopsdk.repository.MallRepository
import com.entersekt.shopsdk.repository.ShopRepository

class ShopsViewModel (application: Application, mallId: Int): AndroidViewModel(application) {

    private val mallRepository: MallRepository
    private val shopRepository: ShopRepository

    var mall: LiveData<Mall>?

    init {
        mallRepository = MallRepository.getInstance(application)
        shopRepository = ShopRepository.getInstance(application)

        mall = mallRepository.getMall(mallId)
    }

    //This would come from api call
    fun saveShops(shops: List<Shop>) {
        shopRepository.insertShops(shops)
    }
}