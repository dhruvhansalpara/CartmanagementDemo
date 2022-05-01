package com.example.cartmanagementapp_demo.PojoClass

data class JsonBaseClass (

    val _id : String,
    val name : ArrayList<String>,
    val price : Int,
    val item_taxes : ArrayList<Int>,
    val specifications : ArrayList<Specifications>

)

