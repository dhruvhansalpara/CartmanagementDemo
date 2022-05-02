package com.example.cartmanagementapp_demo.Roomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_items")
data class CartModel(

    @ColumnInfo(name = "Name")
    var itemName: String,
    @ColumnInfo(name = "PackageName")
    var packageName: String,
    @ColumnInfo(name = "Price")
    var itemPrice: Double,
    @ColumnInfo(name = "IteamCount")
    var IteamCount: Int = 1

) {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}