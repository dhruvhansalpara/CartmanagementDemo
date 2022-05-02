package com.example.cartmanagementapp_demo.Roomdatabase

class CartRepository (private val db: CartDatabase) {

    suspend fun insert(item:CartModel) = db.getCartDao().insert(item)
    suspend fun delete(item:CartModel) = db.getCartDao().delete(item)
    suspend fun update(item: CartModel) = db.getCartDao().updateProduct(item)

    fun allCartItems() = db.getCartDao().getAllGroceryItems()




}