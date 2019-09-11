package com.entersekt.shopper

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.entersekt.shopper.adapters.ShopAdapter
import com.entersekt.shopper.viewModels.ShopsViewModel
import com.entersekt.shopper.viewModels.ShopsViewModelFactory
import kotlinx.android.synthetic.main.activity_cities.*
import kotlinx.android.synthetic.main.activity_shops.*

class ShopsActivity : BaseActivity() {

    private var shopAdapter: ShopAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shops)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setSupportActionBar(toolbar)

        val mallId = intent.extras.getInt("mallId")

        val shopsViewModel = ViewModelProviders.of(this, ShopsViewModelFactory(this.application, mallId))
            .get(ShopsViewModel::class.java)

        shopsViewModel.mall?.observe(this, Observer {
            shopAdapter = ShopAdapter(it.shops)
            recyclerView.adapter = shopAdapter
            shopsViewModel.saveShops(it.shops)
        })
    }
}
