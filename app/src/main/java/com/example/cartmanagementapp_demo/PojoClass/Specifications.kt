package com.example.cartmanagementapp_demo.PojoClass


data class Specifications(val _id : String,
                          val name : ArrayList<String>,
                          val sequence_number : Int,
                          val unique_id : Int,
                          val list : ArrayList<ListData>,
                          val max_range : Int,
                          val range : Int,
                          val type : Int,
                          val is_required : Boolean,
                          val isParentAssociate : Boolean)
