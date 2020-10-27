package com.example.foodapp.feature.adapterClass

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodapp.R
import com.example.foodapp.feature.model.Food
import com.example.foodapp.feature.view.ItemClickListener

class FoodListAdapter(private val foodList : MutableList<Food>, private val itemClickListener: ItemClickListener) :
    RecyclerView.Adapter<FoodViewHolder>() {

    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_food,parent,false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        Glide.with(holder.iv_food_item)
            .load(food.imageUrl)
            .into(holder.iv_food_item)
        holder.tv_foodName.text = food.name
        holder.tv_priceValue.text = holder.itemView.context.getString(R.string.price_format,food.price)

        holder.itemView.setOnClickListener {
            itemClickListener.onItemClicked(position)
        }

    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}