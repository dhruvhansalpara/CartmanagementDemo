package com.example.cartmanagementapp_demo.Roomdatabase

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cartmanagementapp_demo.Utils.Constant.Companion.TotolPrice
import com.example.cartmanagementapp_demo.Utils.Constant.Companion.cartCurrentposion
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CartViewmodel(private val repository: CartRepository): ViewModel() {

    var mutuableCount = MutableLiveData<Int>()

    fun insert(item:CartModel) = GlobalScope.launch {
        repository!!.insert(item)
    }

    fun delete(item: CartModel) = GlobalScope.launch {
        repository.delete(item)
    }
    fun allCartItems() = repository.allCartItems()

    fun getCartCountUpdate(count : Int,totalfinalprice:Double,position : Int){

        var multiplycount = totalfinalprice.toInt() * count

        cartCurrentposion = position

        mutuableCount.value =  multiplycount

        Log.e("dhruvtest","--carttotalupdate0-"+mutuableCount.value.toString()+ " ---"+count+"==="+multiplycount.toInt())

    }


}
