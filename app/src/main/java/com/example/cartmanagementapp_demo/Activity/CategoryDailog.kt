package com.example.cartmanagementapp_demo.Activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cartmanagementapp_demo.Adapter.ApartmentViewAdapter
import com.example.cartmanagementapp_demo.PojoClass.JsonBaseClass
import com.example.cartmanagementapp_demo.R
import kotlinx.android.synthetic.main.subcatagorylist_layout.*

class CategoryDailog : AppCompatActivity() {

    var mainActivity_viewModel: MainActivity_ViewModel? = null

    private val apartmentViewAdapter = ApartmentViewAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.subcatagorylist_layout)

        mainActivity_viewModel = ViewModelProvider(this).get(MainActivity_ViewModel::class.java)

        setData()

        setAppartmentData()

    }

    private fun setAppartmentData() {
        rvApartment.layoutManager = LinearLayoutManager(this)
        rvApartment.adapter =apartmentViewAdapter

    }

    private fun setData() {

        mainActivity_viewModel!!.fetchCards(applicationContext).observe(this,
            Observer<JsonBaseClass> { s ->
                Toast.makeText(this, "" + s.name, Toast.LENGTH_LONG).show()
            })

    }


}