package com.example.cartmanagementapp_demo.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cartmanagementapp_demo.Activity.CategoryDailog
import com.example.cartmanagementapp_demo.PojoClass.JsonBaseClass
import com.example.cartmanagementapp_demo.PojoClass.ListData
import com.example.cartmanagementapp_demo.R
import com.example.cartmanagementapp_demo.Utils.Constant


class ApartmentViewAdapter (val jsonBaseClass: JsonBaseClass,val activity: CategoryDailog): RecyclerView.Adapter<ApartmentViewAdapter.PlanViewHolder>() {


    private var selectedPosition  = -1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.apartment_item_layout, parent, false)
        return PlanViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlanViewHolder, position: Int) {

        val listData : ListData= jsonBaseClass!!.specifications.get(0).list.get(position)

        var replceString : String = listData.name.toString().replace("[", "").replace("]", "");


        holder.rbApartment.text=replceString.toString()
        holder.txtPrice.text="₹ "+listData.price.toString()
        holder.rbApartment.isChecked = position == selectedPosition;

        holder.rbApartment.setOnCheckedChangeListener(
            CompoundButton.OnCheckedChangeListener { _, b ->
                // check condition
                if (b) {
                    // When checked
                    // update selected position
                    selectedPosition = holder.adapterPosition
                    Constant.aparmentsize = selectedPosition
                    notifyDataSetChanged();



                    Log.e("dhruvtest","-aprment-"+Constant.aparmentsize)

                    activity.mainActivity_viewModel!!.getPrice(listData.price.toDouble(),replceString.toString())
                }
            })


    }
    override fun getItemId(position: Int): Long {
        // pass position
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        // pass position
        return position
    }
    override fun getItemCount(): Int {
        return jsonBaseClass!!.specifications.get(0).list.size
    }


    class PlanViewHolder(var view: View) : RecyclerView.ViewHolder(view) {


        var rbApartment: RadioButton
        var txtPrice: TextView



        init {
            rbApartment = view.findViewById(R.id.rbApartment)

            txtPrice = view.findViewById(R.id.txtPrice)
        }
    }



}
