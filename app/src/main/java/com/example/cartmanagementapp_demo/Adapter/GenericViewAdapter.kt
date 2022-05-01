package com.example.cartmanagementapp_demo.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cartmanagementapp_demo.Activity.CategoryDailog
import com.example.cartmanagementapp_demo.PojoClass.JsonBaseClass
import com.example.cartmanagementapp_demo.PojoClass.ListData
import com.example.cartmanagementapp_demo.R

class BedRoomViewAdapter (val jsonBaseClass: JsonBaseClass, val activity: CategoryDailog,var categotyTag : String): RecyclerView.Adapter<BedRoomViewAdapter.PlanViewHolder>() {


    private var selectedPosition  = -1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.bedroom_layoutitem, parent, false)
        return PlanViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlanViewHolder, position: Int) {


        if (categotyTag == "BedRoom"){

            val listData : ListData = jsonBaseClass!!.specifications.get(1).list.get(position)

            holder.txtcheckBOx.text=listData.name.toString()
            holder.txtCleanPrice.text="₹ "+listData.price.toString()


            holder.txtcheckBOx.setOnClickListener { // checkbox.setChecked(true);
                selectedPosition = position
                notifyDataSetChanged()
            }

            if (selectedPosition === position) {
                holder.txtcheckBOx.setChecked(true);
                holder.liCountView.visibility = View.VISIBLE
            } else {
                holder.txtcheckBOx.setChecked(false);
                holder.liCountView.visibility = View.GONE
            }
        }





    }

    override fun getItemCount(): Int {

        var string: String ? = null


        if (categotyTag == "BedRoom"){
            string = jsonBaseClass!!.specifications.get(1).list.size.toString()
        }

        return string!!.toInt()

    }


    class PlanViewHolder(var view: View) : RecyclerView.ViewHolder(view) {


        var txtcheckBOx:CheckBox
        var txtCleanPrice: TextView
        var liCountView : LinearLayout



        init {
            txtcheckBOx = view.findViewById(R.id.txtcheckBOx)
            liCountView = view.findViewById(R.id.liCountView)
            txtCleanPrice = view.findViewById(R.id.txtCleanPrice)
        }
    }



}
