package com.example.cartmanagementapp_demo.PojoClass

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class JsonBaseClass (

    val _id : String,
    val name : ArrayList<String>,
    val price : Int,
    val item_taxes : ArrayList<Int>,
   val specifications : ArrayList<Specifications>


) : Parcelable