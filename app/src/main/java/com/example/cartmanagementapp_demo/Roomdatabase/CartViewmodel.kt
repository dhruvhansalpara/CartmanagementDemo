package com.example.cartmanagementapp_demo.Roomdatabase

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cartmanagementapp_demo.Utils.Constant.Companion.TotolPrice
import com.example.cartmanagementapp_demo.Utils.Constant.Companion.cartCurrentposion
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CartViewmodel(private val repository: CartRepository): ViewModel() {

    var mutuableCount = MutableLiveData<CartModel>()

    fun insert(item:CartModel) = GlobalScope.launch {
        repository!!.insert(item)
    }

    fun delete(item: CartModel) = GlobalScope.launch {
        repository.delete(item)
    }


    fun  update(item: CartModel) = GlobalScope.launch {
        repository.update(item)
    }

    fun allCartItems() = repository.allCartItems()

    fun getCartCountUpdate(cartModel: CartModel){

        var multiplevalue : String ="${cartModel.itemPrice  * cartModel.IteamCount}"
                cartModel.itemPrice = multiplevalue.toDouble()
       cartModel.IteamCount = cartModel.IteamCount
        cartModel.itemName = cartModel.itemName
        cartModel.packageName = cartModel.packageName

        Log.e("dhruvtest","--"+multiplevalue+"--"+cartModel.IteamCount+"---"+cartModel.itemPrice)


        mutuableCount.value =  cartModel



    }


}
