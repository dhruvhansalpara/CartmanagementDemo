package com.example.cartmanagementapp_demo.Roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CartDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: CartModel)

    // Delete function is used to
    // delete data in database.
    @Delete
    suspend fun delete(item: CartModel)

    // getAllGroceryItems function is used to get
    // all the data of database.
    @Query("SELECT * FROM cart_items")
    fun getAllGroceryItems(): LiveData<List<CartModel>>
}