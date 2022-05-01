package com.example.cartmanagementapp_demo.Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cartmanagementapp_demo.R
import kotlinx.android.synthetic.main.mainactivity.*


class MainActivity : AppCompatActivity() {



    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
              setContentView(R.layout.mainactivity)



        setViewId()
    }

    private fun setViewId() {

        txtbtnpress.setOnClickListener {
            startActivity(Intent(this, CategoryDailog::class.java))

            finish()

        }

        ivCart.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))

            finish()
        }


    }
}