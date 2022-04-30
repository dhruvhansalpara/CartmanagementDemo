package com.example.cartmanagementapp_demo.Activity

import android.os.Bundle
import android.util.Log
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

     var apartmentViewAdapter:ApartmentViewAdapter?=null ;

    var jsonBaseClass:JsonBaseClass?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.subcatagorylist_layout)

        mainActivity_viewModel = ViewModelProvider(this).get(MainActivity_ViewModel::class.java)

        setData()

        setAppartmentData()

    }

     fun setAppartmentData() {

        rvApartment.post(Runnable { apartmentViewAdapter!!.notifyDataSetChanged() })

    }

    private fun setData() {

        mainActivity_viewModel!!.fetchCards(applicationContext).observe(this,
            Observer<JsonBaseClass> { s ->
                jsonBaseClass=s;
                apartmentViewAdapter= ApartmentViewAdapter(jsonBaseClass!!,this@CategoryDailog)

                rvApartment.layoutManager = LinearLayoutManager(this)
                rvApartment.adapter =apartmentViewAdapter
                Toast.makeText(this, "" + s.name, Toast.LENGTH_LONG).show()
            })

        mainActivity_viewModel!!.mutuablePrice.observe(this,
            Observer<Double> { s ->
                txtAddOrderPrice.text="Add Order :"+s.toString()
                Log.e("test",""+s.toString())
            })




    }



}