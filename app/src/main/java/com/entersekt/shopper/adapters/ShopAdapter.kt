package com.entersekt.shopper.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.entersekt.shopper.R
import com.entersekt.shopsdk.data.Shop
import kotlinx.android.synthetic.main.list_item_shop.view.*

class ShopAdapter(val shopItems: List<Shop>?) : RecyclerView.Adapter<ShopAdapter.ShopViewHolder>() {

    override fun getItemCount() = shopItems!!.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {

        return ShopViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item_shop,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        holder.itemView.shop_item_title.text = shopItems!![position].name
    }

    class ShopViewHolder(v: View) : RecyclerView.ViewHolder(v)
}
