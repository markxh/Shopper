package com.entersekt.shopper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.entersekt.shopper.adapters.MallAdapter
import com.entersekt.shopper.viewModels.MallsViewModel
import com.entersekt.shopper.viewModels.MallsViewModelFactory
import com.entersekt.shopsdk.data.City
import kotlinx.android.synthetic.main.activity_cities.*
import kotlinx.android.synthetic.main.activity_malls.*

class MallsActivity : BaseActivity() {

    private var mallAdapter: MallAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_malls)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setSupportActionBar(toolbar)

        val cityId = intent.extras.getInt("cityId")

        val mallsViewModel =
            ViewModelProviders.of(this, MallsViewModelFactory(this.application, cityId))
                .get(MallsViewModel::class.java)

        mallsViewModel.city?.observe(this, Observer {
            mallAdapter = MallAdapter(it.malls)
            recyclerView.adapter = mallAdapter
            mallsViewModel.saveMalls(it.malls)
        })
    }
}
