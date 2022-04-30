package com.example.cartmanagementapp_demo.Activity

data class HomeState (
    var loading: Boolean = false,
    var success: Boolean = false,
    var failure: Boolean = false,
    var message: String? = null,
    var data: Any? = null
)