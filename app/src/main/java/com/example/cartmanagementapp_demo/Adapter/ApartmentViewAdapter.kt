package com.example.cartmanagementapp_demo.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cartmanagementapp_demo.Activity.CategoryDailog
import com.example.cartmanagementapp_demo.PojoClass.JsonBaseClass
import com.example.cartmanagementapp_demo.PojoClass.ListData
import com.example.cartmanagementapp_demo.R


class ApartmentViewAdapter (val jsonBaseClass: JsonBaseClass,val activity: CategoryDailog): RecyclerView.Adapter<ApartmentViewAdapter.PlanViewHolder>() {


    private var lastCheckedPosition = -1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.apartment_item_layout, parent, false)
        return PlanViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlanViewHolder, position: Int) {

        val listData : ListData= jsonBaseClass!!.specifications.get(0).list.get(position)
        holder.rbApartment.text=listData.name.toString()
        holder.txtPrice.text=listData.price.toString()



        holder.rgGroup.setOnCheckedChangeListener { radioGroup, optionId ->
            run {
                when (optionId) {
                    R.id.rbApartment -> {
                        // do something when radio button 1 is selected





                        activity.mainActivity_viewModel!!.getPrice(listData.price.toDouble())


                    }

                    // add more cases here to handle other buttons in the your RadioGroup
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return jsonBaseClass!!.specifications.get(0).list.size
    }


    class PlanViewHolder(var view: View) : RecyclerView.ViewHolder(view) {


        var rbApartment: RadioButton
        var rgGroup: RadioGroup
        var txtPrice: TextView



        init {
            rbApartment = view.findViewById(R.id.rbApartment)
            rgGroup = view.findViewById(R.id.rgGroup)
            txtPrice = view.findViewById(R.id.txtPrice)
        }
    }



}
