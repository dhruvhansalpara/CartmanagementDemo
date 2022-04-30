package com.example.cartmanagementapp_demo.Activity

import android.app.Application
import android.content.Context
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cartmanagementapp_demo.PojoClass.JsonBaseClass
import com.example.cartmanagementapp_demo.Utils.AppRepo
import com.example.cartmanagementapp_demo.Utils.utils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity_ViewModel(application: Application) : AndroidViewModel(application)
{


    private var mutablejsonlist = MutableLiveData<JsonBaseClass>()


    var utils : utils = utils();
    var customisebtnClick = MutableLiveData<String>()


    fun fetchCards(context: Context) :MutableLiveData<JsonBaseClass> {
       val appRepo =  AppRepo()

        mutablejsonlist =  appRepo.fetchCards(context)
        return mutablejsonlist

    }

    fun onClick(view: View?) {

        customisebtnClick.value = "click"


    }


}