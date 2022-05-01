package com.example.cartmanagementapp_demo.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.cartmanagementapp_demo.Activity.CategoryDailog
import com.example.cartmanagementapp_demo.PojoClass.JsonBaseClass
import com.example.cartmanagementapp_demo.PojoClass.ListData
import com.example.cartmanagementapp_demo.R
import com.example.cartmanagementapp_demo.Roomdatabase.CartModel
import com.example.cartmanagementapp_demo.Roomdatabase.CartViewmodel
import com.example.cartmanagementapp_demo.Utils.Constant

class GenericViewAdapter(
    val jsonBaseClass: JsonBaseClass,
    val activity: CategoryDailog,
    var categotyTag: String
) : RecyclerView.Adapter<GenericViewAdapter.PlanViewHolder>() {


    private var selectedPosition = -1

    lateinit var ViewModel: CartViewmodel

    private var BedtotolAmout: Int = 0
    private var BathRoomtotolAmout: Int = 0
    private var RoomtotolAmout: Int = 0
    private var KitchentotolAmout: Int = 0

    var BedroomSize: Int = 0
    var BathroomSize: Int = 0
    var roomSize: Int = 0
    var KitchenSize: Int = 0

    var bedselectionname = ""
    var bathselectionanme = ""
    var roomselection = ""
    var kitchenselection = ""

        override

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.bedroom_layoutitem, parent, false)
        return PlanViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlanViewHolder, position: Int) {

        Log.e("dhruvtest", "--" + position)

        if (categotyTag == "BedRoom") {

            BedroomSize = jsonBaseClass!!.specifications.get(1).list.size.toInt()

            val listData: ListData = jsonBaseClass!!.specifications.get(1).list.get(position)
            var replceString = listData.name.toString().replace("[", "").replace("]", "");
            holder.txtcheckBOx.text = replceString.toString()
            holder.txtCleanPrice.text = "₹ " + listData.price.toString()


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

            var totalcount: Int = 0

            holder.btn_plus.setOnClickListener {

                if (totalcount >= 0) {
                    totalcount += 1
                    BedroomupdateView(totalcount, holder, position, listData.price,replceString.toString())

                } else {
                    totalcount = 0
                    BedroomupdateView(totalcount, holder, position, listData.price,replceString)
                }


            }
            holder.btn_minus.setOnClickListener {
                if (totalcount >= 0) {
                    totalcount -= 1
                    BedroomupdateView(totalcount, holder, position, listData.price,replceString)
                } else {
                    totalcount = 0
                    BedroomupdateView(totalcount, holder, position, listData.price,replceString)
                }
            }


        }

        if (categotyTag == "Bathroom" ) {

            BathroomSize = jsonBaseClass!!.specifications.get(6).list.size.toInt()


            val listData: ListData = jsonBaseClass!!.specifications.get(6).list.get(position)
            var replceString = listData.name.toString().replace("[", "").replace("]", "");

            holder.txtcheckBOx.text = replceString.toString()



            holder.txtCleanPrice.text = "₹ " + listData.price.toString()


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

            var totalcount: Int = 0

            holder.btn_plus.setOnClickListener {

                if (totalcount >= 0) {
                    totalcount += 1
                    BathroomupdateView(totalcount, holder, position, listData.price,replceString)
                } else {
                    totalcount = 0
                    BathroomupdateView(totalcount, holder, position, listData.price,replceString)
                }


            }
            holder.btn_minus.setOnClickListener {
                if (totalcount >= 0) {
                    totalcount -= 1
                    BathroomupdateView(totalcount, holder, position, listData.price,replceString)
                } else {
                    totalcount = 0
                    BathroomupdateView(totalcount, holder, position, listData.price,replceString)
                }
            }

        }

        if (categotyTag == "RoomView" ) {

            roomSize = jsonBaseClass!!.specifications.get(9).list.size.toInt()

            val listData: ListData = jsonBaseClass!!.specifications.get(9).list.get(position)
            var replceString = listData.name.toString().replace("[", "").replace("]", "");

            holder.txtcheckBOx.text = replceString.toString()


            holder.txtCleanPrice.text = "₹ " + listData.price.toString()


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

            var totalcount: Int = 0

            holder.btn_plus.setOnClickListener {

                if (totalcount >= 0) {
                    totalcount += 1
                    RoomupdateView(totalcount, holder, position, listData.price,replceString)
                } else {
                    totalcount = 0
                    RoomupdateView(totalcount, holder, position, listData.price,replceString)
                }


            }
            holder.btn_minus.setOnClickListener {
                if (totalcount >= 0) {
                    totalcount -= 1
                    RoomupdateView(totalcount, holder, position, listData.price,replceString)
                } else {
                    totalcount = 0
                    RoomupdateView(totalcount, holder, position, listData.price,replceString)
                }
            }


        }
        if (categotyTag == "Kitchen" ) {

            roomSize = jsonBaseClass!!.specifications.get(14).list.size.toInt()

            val listData: ListData = jsonBaseClass!!.specifications.get(14).list.get(position)
            var replceString = listData.name.toString().replace("[", "").replace("]", "");

            holder.txtcheckBOx.text = replceString.toString()



            holder.txtCleanPrice.text = "₹ " + listData.price.toString()


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

            var totalcount: Int = 0

            holder.btn_plus.setOnClickListener {

                if (totalcount >= 0) {
                    totalcount += 1
                    KitchenupdateView(totalcount, holder, position, listData.price,replceString)
                } else {
                    totalcount = 0
                    KitchenupdateView(totalcount, holder, position, listData.price,replceString)
                }


            }
            holder.btn_minus.setOnClickListener {
                if (totalcount >= 0) {
                    totalcount -= 1
                    KitchenupdateView(totalcount, holder, position, listData.price,replceString)
                } else {
                    totalcount = 0
                    KitchenupdateView(totalcount, holder, position, listData.price,replceString)
                }
            }
        }


    }

    fun BedroomupdateView(quantity: Int, view: PlanViewHolder, position: Int, price: Int,name : String) {
        Log.e("dhruvtest", "-bedposition-" + position.toString())
        view.tv_item_count.text = quantity.toString()

        BedtotolAmout = quantity * price
        bedselectionname = name.toString()




        activity.mainActivity_viewModel!!.getbedroomPrice(BedtotolAmout.toDouble(),bedselectionname)
        Log.e("dhruvtest", "-totalprice-" + BedtotolAmout.toString())


    }

    fun BathroomupdateView(quantity: Int, view: PlanViewHolder, position: Int, price: Int,name : String) {
        Log.e("dhruvtest", "-bathposition-" + position.toString())
        view.tv_item_count.text = quantity.toString()
        BathRoomtotolAmout = quantity * price

        bathselectionanme = name.toString()

        activity.mainActivity_viewModel!!.getbathroomPrice(BathRoomtotolAmout.toDouble(),bathselectionanme)

    }

    fun RoomupdateView(quantity: Int, view: PlanViewHolder, position: Int, price: Int,name : String) {
        Log.e("dhruvtest", "-roomposition-" + position.toString())
        view.tv_item_count.text = quantity.toString()
        RoomtotolAmout = quantity * price

        roomselection  = name.toString()

        activity.mainActivity_viewModel!!.geroomPrice(RoomtotolAmout.toDouble(),roomselection)



    }

    fun KitchenupdateView(quantity: Int, view: PlanViewHolder, position: Int, price: Int,name : String) {
        Log.e("dhruvtest", "-kitchenposition-" + position.toString())
        view.tv_item_count.text = quantity.toString()
        KitchentotolAmout = quantity * price

        kitchenselection = name.toString()

        activity.mainActivity_viewModel!!.getkitchenroomPrice(KitchentotolAmout.toDouble(),kitchenselection)
    }




    override fun getItemCount(): Int {

        var string: String? = null


        if (categotyTag == "BedRoom") {
            string = jsonBaseClass!!.specifications.get(1).list.size.toString()
        }
        if (categotyTag == "Bathroom") {
            string = jsonBaseClass!!.specifications.get(6).list.size.toString()
        }
        if (categotyTag == "RoomView") {
            string = jsonBaseClass!!.specifications.get(9).list.size.toString()
        }
        if (categotyTag == "Kitchen") {
            string = jsonBaseClass!!.specifications.get(14).list.size.toString()
        }

        return string!!.toInt()

    }


    class PlanViewHolder(var view: View) : RecyclerView.ViewHolder(view) {


        var txtcheckBOx: CheckBox
        var txtCleanPrice: TextView
        var liCountView: LinearLayout
        var btn_plus: AppCompatButton
        var btn_minus: AppCompatButton
        var tv_item_count: AppCompatTextView


        init {
            txtcheckBOx = view.findViewById(R.id.txtcheckBOx)
            liCountView = view.findViewById(R.id.liCountView)
            txtCleanPrice = view.findViewById(R.id.txtCleanPrice)
            btn_plus = view.findViewById(R.id.btn_plus_checkBox)
            tv_item_count = view.findViewById(R.id.tv_item_count_checkBox)
            btn_minus = view.findViewById(R.id.btn_minus_checkBox)


        }
    }


}
