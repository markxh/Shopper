package com.entersekt.shopper.adapters

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.entersekt.shopper.MallsActivity
import com.entersekt.shopper.R
import com.entersekt.shopsdk.data.City
import kotlinx.android.synthetic.main.list_item_city.view.*

class CityAdapter(val cityItems: List<City>?) : RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    override fun getItemCount() = cityItems!!.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {

        return CityViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item_city,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.itemView.city_item_title.text = cityItems!![position].name
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, MallsActivity::class.java)
            val bundle = Bundle()
            bundle.putParcelable("city", cityItems[position])
            intent.putExtra("bundle", bundle)
            ContextCompat.startActivity(it.context, intent, null)
        }
    }

    class CityViewHolder(v: View) : RecyclerView.ViewHolder(v)
}