package com.example.foodapp.feature.view

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.core.BaseActivity
import com.example.foodapp.feature.adapterClass.FoodListAdapter
import com.example.foodapp.feature.model.Food
import com.example.foodapp.feature.presenter.FoodListPresenter
import com.example.foodapp.feature.presenter.FoodListPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*


class MainActivity : BaseActivity(),FoodListView {
    override fun setLayoutId(): Int {
       return R.layout.activity_main
    }

    override fun setToolbar(): Toolbar {
        toolbar.title = getString(R.string.title_food_list)
        return toolbar
    }

    override val isHomeUpButtonEnable: Boolean get()= false

    private lateinit var presenter: FoodListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = FoodListPresenterImpl(this)
        presenter.getFoodList()
    }


    override fun progressBarVisibility(isVisible: Boolean) {

        if (isVisible)
            progress.visibility = View.VISIBLE
        else
            progress.visibility = View.GONE
    }

    override fun onFoodListRetrieveSuccess(foodList: MutableList<Food>) {
      initFoodAdapter(foodList)
    }

    override fun onFoodListRetrieveFailure(errorMessage: String) {
        showToast(errorMessage)
    }

    private fun initFoodAdapter(foodList: MutableList<Food>) {
        val adapter = FoodListAdapter(foodList, object : ItemClickListener {
            override fun onItemClicked(position: Int) {
                showToast("item clicked")
            }
        })
        val  recyclerView = findViewById<RecyclerView>(R.id.recyclerViewId)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter

    }


}