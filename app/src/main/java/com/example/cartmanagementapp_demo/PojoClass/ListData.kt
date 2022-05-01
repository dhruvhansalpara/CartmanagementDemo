package com.example.cartmanagementapp_demo.PojoClass



data class ListData(

    val _id : String,
    val name : ArrayList<String>,
    val price : Int,
    val sequence_number : Int,
    val is_default_selected : Boolean,
    val specification_group_id : String,
    val unique_id : Int
)