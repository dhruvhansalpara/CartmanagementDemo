package com.example.cartmanagementapp_demo.Utils

import android.content.Context
import java.io.IOException
import java.io.InputStream

public class utils {


    fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }




}