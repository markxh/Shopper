package com.entersekt.shopper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.entersekt.shopper.adapters.CityAdapter
import com.entersekt.shopper.viewModels.CitiesViewModel
import kotlinx.android.synthetic.main.activity_cities.*

class CitiesActivity : AppCompatActivity() {

    private val citiesViewModel: CitiesViewModel by lazy {
        ViewModelProviders.of(this).get(CitiesViewModel::class.java)
    }

    private var cityAdapter: CityAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cities)

        loadCities()
    }

    fun loadCities() {
        citiesViewModel.cities.observe(this, Observer {
            cityAdapter = CityAdapter(it)
            recyclerView.adapter = cityAdapter
        })
    }
}
