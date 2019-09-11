package com.entersekt.shopper.viewModels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ShopsViewModelFactory(private val application: Application, private val mallId: Int)
    : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShopsViewModel(application, mallId) as T
    }
}