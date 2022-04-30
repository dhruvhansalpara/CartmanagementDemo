package com.example.kotlinsampleapp.module

import com.example.cartmanagementapp_demo.Activity.MainActivity_ViewModel
import com.example.cartmanagementapp_demo.Utils.utils
import io.reactivex.schedulers.Schedulers.single

import org.koin.dsl.module.module

var appModule = module {
    single { utils() }
    factory { MainActivity_ViewModel(get()) }
}