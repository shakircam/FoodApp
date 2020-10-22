package com.example.foodapp.model

interface FoodListCallBack {
    fun onSuccess(foodList: MutableList<Food>)
    fun onError(throwable: Throwable)
}