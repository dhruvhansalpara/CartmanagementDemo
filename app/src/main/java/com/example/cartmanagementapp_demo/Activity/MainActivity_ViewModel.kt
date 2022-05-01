package com.example.cartmanagementapp_demo.Activity

import android.app.Application
import android.content.Context
import android.util.Log
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cartmanagementapp_demo.PojoClass.JsonBaseClass
import com.example.cartmanagementapp_demo.Roomdatabase.CartModel
import com.example.cartmanagementapp_demo.Roomdatabase.CartRepository
import com.example.cartmanagementapp_demo.Utils.AppRepo
import com.example.cartmanagementapp_demo.Utils.Constant.Companion.TotolInfoAbout
import com.example.cartmanagementapp_demo.Utils.utils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.function.DoubleBinaryOperator

class MainActivity_ViewModel(application: Application) : AndroidViewModel(application)
{


    private val repository: CartRepository ? = null

    private var mutablejsonlist = MutableLiveData<JsonBaseClass>()

    var mutuablePrice = MutableLiveData<Double>()

    var appartment_price:Double?=0.00;
    var bedroomPrice : Double ? = 0.00;
    var bathroomPrice : Double ? = 0.00;
    var roomPrice : Double ? = 0.00;
    var kitchenPrice : Double ? = 0.00;

    var bottomfinalCount : Int ? = 0






    var utils : utils = utils();



    fun fetchCards(context: Context) :MutableLiveData<JsonBaseClass> {
       val appRepo =  AppRepo()

        mutablejsonlist =  appRepo.fetchCards(context)
        return mutablejsonlist

    }


    fun getPrice(spectificationL:Double){

        appartment_price=0.0;

        if(bottomfinalCount!! > 0){
            appartment_price= spectificationL * bottomfinalCount!!;
        }else{
            appartment_price= spectificationL
        }



        mutuablePrice.value=appartment_price

    }

    fun getbedroomPrice(bedroom:Double,name : String){

        bedroomPrice=0.0;
        bedroomPrice= bedroom ;

        Log.e("dhruvtest","--totalprice-"+bedroomPrice.toString())

        TotolInfoAbout = name

        mutuablePrice.value= appartment_price?.plus(bedroomPrice!!.toDouble())

        //mutuablePrice.value=appartment_price

    }

    fun getbathroomPrice(bedroom:Double,name : String){

        bathroomPrice=0.0;
        bathroomPrice= bedroom ;

        Log.e("dhruvtest","--totalprice-"+bathroomPrice.toString())

        TotolInfoAbout = name

        mutuablePrice.value= appartment_price?.plus(bedroomPrice!!.toDouble())?.plus(bathroomPrice!!.toDouble())

        //mutuablePrice.value=appartment_price

    }

    fun geroomPrice(bedroom:Double,name : String){

        roomPrice=0.0;
        roomPrice= bedroom ;

        Log.e("dhruvtest","--totalprice-"+roomPrice.toString())

        TotolInfoAbout = name

        mutuablePrice.value= appartment_price?.plus(bedroomPrice!!.toDouble())?.plus(bathroomPrice!!.toDouble())
            ?.plus(roomPrice!!.toDouble())


        //mutuablePrice.value=appartment_price

    }

    fun getkitchenroomPrice(bedroom:Double,name : String){
        kitchenPrice=0.0;
        kitchenPrice= bedroom ;

        Log.e("dhruvtest","--totalprice-"+kitchenPrice.toString())

        TotolInfoAbout = name

        mutuablePrice.value= appartment_price?.plus(bedroomPrice!!.toDouble())?.plus(bathroomPrice!!.toDouble())
            ?.plus(roomPrice!!.toDouble())?.plus(kitchenPrice!!.toDouble())


        //mutuablePrice.value=appartment_price

    }

    fun getBottomfinalPrice(finalprice : Int , isclick : Boolean ){

       if (isclick){
           bottomfinalCount = finalprice


       }else{
           bottomfinalCount = 0
       }


    }





}