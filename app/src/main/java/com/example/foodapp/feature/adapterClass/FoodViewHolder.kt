package com.example.foodapp.feature.adapterClass

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R

class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val iv_food_item : ImageView = itemView.findViewById(R.id.iv_food_item)
    val tv_foodName : TextView = itemView.findViewById(R.id.tv_foodName)
    val tv_priceValue : TextView  = itemView.findViewById(R.id.tv_priceValue)
    //val iv_favoriteItem : TextView  = itemView.findViewById(R.id.iv_favoriteItem)


}
