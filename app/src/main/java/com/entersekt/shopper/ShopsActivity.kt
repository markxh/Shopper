package com.entersekt.shopper

import android.os.Bundle
import com.entersekt.shopsdk.data.Mall
import com.entersekt.shopsdk.data.Shop
import kotlinx.android.synthetic.main.activity_cities.*
import kotlinx.android.synthetic.main.activity_shops.*

class ShopsActivity : BaseActivity() {

    private var shopAdapter: ShopAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shops)
        setSupportActionBar(toolbar)

        val bundle = intent.getBundleExtra("bundle")

        shopAdapter = ShopAdapter(bundle.getParcelable<Mall>("mall")?.shops)
        recyclerView.adapter = shopAdapter
    }
}
