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
import com.entersekt.shopper.ShopsActivity
import com.entersekt.shopsdk.data.Mall
import kotlinx.android.synthetic.main.list_item_city.view.*
import kotlinx.android.synthetic.main.list_item_mall.view.*

class MallAdapter(val mallItems: List<Mall>?) : RecyclerView.Adapter<MallAdapter.MallViewHolder>() {

    override fun getItemCount() = mallItems!!.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MallViewHolder {

        return MallViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item_mall,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MallViewHolder, position: Int) {
        holder.itemView.mall_item_title.text = mallItems!![position].name
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, ShopsActivity::class.java)
            intent.putExtra("mallId", mallItems[position].id)
            ContextCompat.startActivity(it.context, intent, null)
        }
    }

    class MallViewHolder(v: View) : RecyclerView.ViewHolder(v)
}