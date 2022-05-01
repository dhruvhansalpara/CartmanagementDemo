package com.example.cartmanagementapp_demo.Roomdatabase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cartmanagementapp_demo.Activity.MainActivity_ViewModel

class CartViewModelFactory(private val repository: CartRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CartViewmodel(repository) as T
    }
}