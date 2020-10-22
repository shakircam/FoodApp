package com.example.foodapp.network

import com.example.foodapp.model.Food
import retrofit2.Call
import retrofit2.http.GET

interface FoodApiInterface {
    @GET("" )
    fun getFoodList(): Call<MutableList<Food>>
}