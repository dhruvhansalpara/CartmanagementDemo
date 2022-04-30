package com.example.cartmanagementapp_demo.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cartmanagementapp_demo.R


class ApartmentViewAdapter : RecyclerView.Adapter<ApartmentViewAdapter.PlanViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.apartment_item_layout, parent, false)
        return PlanViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlanViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


    class PlanViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

    }



}
