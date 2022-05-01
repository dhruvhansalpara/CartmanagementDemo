package com.example.cartmanagementapp_demo.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cartmanagementapp_demo.Adapter.ApartmentViewAdapter
import com.example.cartmanagementapp_demo.Adapter.GenericViewAdapter
import com.example.cartmanagementapp_demo.PojoClass.JsonBaseClass
import com.example.cartmanagementapp_demo.R
import com.example.cartmanagementapp_demo.Roomdatabase.*
import com.example.cartmanagementapp_demo.Utils.Constant
import com.example.cartmanagementapp_demo.Utils.Constant.Companion.PackageName
import com.example.cartmanagementapp_demo.Utils.Constant.Companion.TotolInfoAbout
import com.example.cartmanagementapp_demo.Utils.Constant.Companion.TotolPrice
import kotlinx.android.synthetic.main.subcatagorylist_layout.*

class CategoryDailog : AppCompatActivity() {

    var mainActivity_viewModel: MainActivity_ViewModel? = null

    var cart_viewModel : CartViewmodel ? = null

    var apartmentViewAdapter:ApartmentViewAdapter?=null
    var genericViewAdapter :GenericViewAdapter ? = null
    var totalcount: Int = 0

    var bottomfinaltotal : Int = 0
    var isbotomcountclick : Boolean = false

    var jsonBaseClass:JsonBaseClass?=null

     val db: CartDatabase ? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.subcatagorylist_layout)

        getSupportActionBar()?.setTitle("Make Your Own Package");

        mainActivity_viewModel = ViewModelProvider(this).get(MainActivity_ViewModel::class.java)
       // cart_viewModel = ViewModelProvider(this).get(CartViewmodel::class.java)

        val cartRepository = CartRepository(CartDatabase(this))

        val factory =
            CartViewModelFactory(cartRepository)

        cart_viewModel = ViewModelProvider(this,factory).get(CartViewmodel::class.java)

        btn_plus_bottom.setOnClickListener {

            isbotomcountclick = true
            if (totalcount >= 0){
                totalcount += 1
                setBottomTotal(totalcount)


            }else{
                totalcount = 0
                isbotomcountclick = false
                setBottomTotal(totalcount)
            }
        }

        btn_minus_bottom.setOnClickListener {
            isbotomcountclick = true
            if(totalcount >= 0){
                totalcount -= 1
                setBottomTotal(totalcount)

            }else{
                totalcount = 0
                isbotomcountclick = false
                setBottomTotal(totalcount)

            }

        }
        setData()

        setAppartmentData()

    }

     fun setBottomTotal(totalcount: Int) {
         bottomfinaltotal = totalcount

         tv_item_count_bottom.text = bottomfinaltotal.toString()

         mainActivity_viewModel!!.getBottomfinalPrice(bottomfinaltotal,true)

     }

    fun setAppartmentData() {

        rvApartment.post(Runnable { apartmentViewAdapter!!.notifyDataSetChanged() })
         rvBedroom.post(Runnable{
             genericViewAdapter!!.notifyDataSetChanged()
         })

    }

    private fun setData() {

        mainActivity_viewModel!!.fetchCards(applicationContext).observe(this,
            Observer<JsonBaseClass> { s ->
                jsonBaseClass=s;
                apartmentViewAdapter= ApartmentViewAdapter(jsonBaseClass!!,this@CategoryDailog)

                rvApartment.layoutManager = LinearLayoutManager(this)
                rvApartment.adapter =apartmentViewAdapter


                genericViewAdapter = GenericViewAdapter(jsonBaseClass!!,this,"BedRoom")
                rvBedroom.layoutManager = LinearLayoutManager(this)
                rvBedroom.adapter = genericViewAdapter


                genericViewAdapter = GenericViewAdapter(jsonBaseClass!!,this,"Bathroom")
                rvBathroom.layoutManager = LinearLayoutManager(this)
                rvBathroom.adapter = genericViewAdapter

                genericViewAdapter = GenericViewAdapter(jsonBaseClass!!,this,"RoomView")
                rvRoomView.layoutManager = LinearLayoutManager(this)
                rvRoomView.adapter = genericViewAdapter

                genericViewAdapter = GenericViewAdapter(jsonBaseClass!!,this,"Kitchen")
                rvKitchen.layoutManager = LinearLayoutManager(this)
                rvKitchen.adapter = genericViewAdapter




                //Toast.makeText(this, "" + s.name, Toast.LENGTH_LONG).show()
            })

        txtAddOrderPrice.setOnClickListener {


            var item = CartModel(Constant.TotolInfoAbout, Constant.PackageName, Constant.TotolPrice)

            Log.e("dhruvtest","-data-"+item.toString())

            cart_viewModel!!.insert(item)
            startActivity(Intent(this, CartActivity::class.java))




        }

        mainActivity_viewModel!!.mutuablePrice.observe(this,
            Observer<Double> { s ->
                TotolPrice = s.toDouble()

                txtAddOrderPrice.text="Add Order : "+s.toString()
                Log.e("test",""+s.toString())




            })




    }



}