package com.example.cartmanagementapp_demo.Utils

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.cartmanagementapp_demo.PojoClass.JsonBaseClass
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AppRepo {

    private var mutablejsonlist = MutableLiveData<JsonBaseClass>()

    var utils : utils = utils();

    fun fetchCards(context: Context) :MutableLiveData<JsonBaseClass> {
        val jsonString = utils.getJsonDataFromAsset(context, "item_data.json")

        val gson = Gson()
        val listCardType = object: TypeToken<JsonBaseClass>() {}.type

        val cards = gson.fromJson<JsonBaseClass>(jsonString, listCardType)
        mutablejsonlist.value = cards

        return mutablejsonlist
    }
}