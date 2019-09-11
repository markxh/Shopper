package com.entersekt.shopper.viewModels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MallsViewModelFactory(private val application: Application, private val cityId: Int)
    : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MallsViewModel(application, cityId) as T
    }
}