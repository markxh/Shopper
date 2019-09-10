package com.entersekt.shopper

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.entersekt.shopper.adapters.MallAdapter
import com.entersekt.shopper.viewModels.MallsViewModel
import com.entersekt.shopsdk.data.City
import kotlinx.android.synthetic.main.activity_cities.*
import kotlinx.android.synthetic.main.activity_malls.*

class MallsActivity : BaseActivity() {

    private val mallsViewModel: MallsViewModel by lazy {
        ViewModelProviders.of(this).get(MallsViewModel::class.java)
    }

    private var mallAdapter: MallAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_malls)
        setSupportActionBar(toolbar)

        val bundle = intent.getBundleExtra("bundle")

        mallAdapter = MallAdapter(bundle.getParcelable<City>("city")?.malls)
        recyclerView.adapter = mallAdapter
    }
}
