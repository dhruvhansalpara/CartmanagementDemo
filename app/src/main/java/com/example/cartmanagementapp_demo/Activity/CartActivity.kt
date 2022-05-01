package com.example.cartmanagementapp_demo.Activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cartmanagementapp_demo.Adapter.CartAdapter
import com.example.cartmanagementapp_demo.R
import com.example.cartmanagementapp_demo.Roomdatabase.*
import com.example.cartmanagementapp_demo.Utils.Constant
import com.example.cartmanagementapp_demo.Utils.Constant.Companion.CartCountPrice
import kotlinx.android.synthetic.main.cart_layout.*
import kotlinx.android.synthetic.main.subcatagorylist_layout.*

class CartActivity : AppCompatActivity() {


    lateinit var ViewModel: CartViewmodel
    lateinit var list: List<CartModel>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cart_layout)


        supportActionBar!!.title = " Cart View"

        val cartRepository = CartRepository(CartDatabase(this))



        val factory =
            CartViewModelFactory(cartRepository)

        ViewModel = ViewModelProvider(this,factory).get(CartViewmodel::class.java)

        val cartAdapter = CartAdapter(listOf(), ViewModel)



        rvCartView.layoutManager = LinearLayoutManager(this)
        rvCartView.adapter = cartAdapter

//        To display all items in recycler view
        ViewModel!!.allCartItems().observe(this, Observer{
            cartAdapter!!.list = it
            cartAdapter.notifyDataSetChanged()


        })

        ViewModel!!.mutuableCount.observe(this,
            Observer<Int> { s ->

                CartCountPrice = s


               // txtAddOrderPrice.text="Add Order : "+s.toString()
                Log.e("test",""+s.toString())




            })



    }


}