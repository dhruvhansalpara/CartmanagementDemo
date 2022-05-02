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
import androidx.constraintlayout.solver.GoalRow
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

            var listData: ListData ? = null

            if(Constant.aparmentsize == 0){
                BedroomSize = jsonBaseClass!!.specifications.get(1).list.size.toInt()
                 listData = jsonBaseClass!!.specifications.get(1).list.get(position)

            }else if(Constant.aparmentsize == 1){
                BedroomSize = jsonBaseClass!!.specifications.get(2).list.size.toInt()
                 listData = jsonBaseClass!!.specifications.get(2).list.get(position)

            }else if(Constant.aparmentsize == 2){
                BedroomSize = jsonBaseClass!!.specifications.get(3).list.size.toInt()
                 listData = jsonBaseClass!!.specifications.get(3).list.get(position)

            }else if(Constant.aparmentsize == 3){
                BedroomSize = jsonBaseClass!!.specifications.get(4).list.size.toInt()
                listData = jsonBaseClass!!.specifications.get(4).list.get(position)

            }else if(Constant.aparmentsize == 4){
                BedroomSize = jsonBaseClass!!.specifications.get(5).list.size.toInt()
                listData = jsonBaseClass!!.specifications.get(5).list.get(position)

            }



            var replceString = listData!!.name.toString().replace("[", "").replace("]", "");
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
                    BedroomupdateView(totalcount, holder, position, listData!!.price,replceString.toString())

                } else {
                    totalcount = 0
                    BedroomupdateView(totalcount, holder, position, listData!!.price,replceString)
                }


            }
            holder.btn_minus.setOnClickListener {
                if (totalcount >= 0) {
                    totalcount -= 1
                    BedroomupdateView(totalcount, holder, position, listData!!.price,replceString)
                } else {
                    totalcount = 0
                    BedroomupdateView(totalcount, holder, position, listData!!.price,replceString)
                }
            }


        }

        if (categotyTag == "Bathroom" ) {

            var listData: ListData ? = null

            var replceString : String ? = null

            if(Constant.aparmentsize == 0){
                holder.liMainView.visibility = View.VISIBLE

                BathroomSize = jsonBaseClass!!.specifications.get(6).list.size.toInt()
                listData = jsonBaseClass!!.specifications.get(6).list.get(position)

                replceString = listData!!.name.toString().replace("[", "").replace("]", "");


            }else if(Constant.aparmentsize == 1){
                holder.liMainView.visibility = View.VISIBLE
                BathroomSize = jsonBaseClass!!.specifications.get(7).list.size.toInt()
                listData = jsonBaseClass!!.specifications.get(7).list.get(position)

                replceString = listData!!.name.toString().replace("[", "").replace("]", "");



            }else if(Constant.aparmentsize == 2){
                holder.liMainView.visibility = View.VISIBLE
                BathroomSize = jsonBaseClass!!.specifications.get(8).list.size.toInt()
                listData = jsonBaseClass!!.specifications.get(8).list.get(position)
                replceString = listData!!.name.toString().replace("[", "").replace("]", "");


            }else if(Constant.aparmentsize == 3){
                holder.liMainView.visibility = View.VISIBLE
                BathroomSize = jsonBaseClass!!.specifications.get(8).list.size.toInt()
                listData = jsonBaseClass!!.specifications.get(8).list.get(position)
                replceString = listData!!.name.toString().replace("[", "").replace("]", "");

            }else if(Constant.aparmentsize == 4){
                holder.liMainView.visibility = View.VISIBLE
                BathroomSize = jsonBaseClass!!.specifications.get(8).list.size.toInt()
                listData = jsonBaseClass!!.specifications.get(8).list.get(position)
                replceString = listData!!.name.toString().replace("[", "").replace("]", "");

            }


            holder.txtcheckBOx.text = replceString!!.toString()



            holder.txtCleanPrice.text = "₹ " + listData!!.price.toString()


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
                    BathroomupdateView(totalcount, holder, position, listData!!.price,replceString!!)
                } else {
                    totalcount = 0
                    BathroomupdateView(totalcount, holder, position, listData!!.price,replceString!!)
                }


            }
            holder.btn_minus.setOnClickListener {
                if (totalcount >= 0) {
                    totalcount -= 1
                    BathroomupdateView(totalcount, holder, position, listData!!.price,replceString!!)
                } else {
                    totalcount = 0
                    BathroomupdateView(totalcount, holder, position, listData!!.price,replceString!!)
                }
            }

        }

        if (categotyTag == "RoomView" ) {
            var listData: ListData ? = null

            if(Constant.aparmentsize == 0){
                roomSize = jsonBaseClass!!.specifications.get(9).list.size.toInt()
                listData = jsonBaseClass!!.specifications.get(9).list.get(position)

            }else if(Constant.aparmentsize == 1){
                roomSize = jsonBaseClass!!.specifications.get(10).list.size.toInt()
                listData = jsonBaseClass!!.specifications.get(10).list.get(position)

            }else if(Constant.aparmentsize == 2){
                roomSize = jsonBaseClass!!.specifications.get(11).list.size.toInt()
                listData = jsonBaseClass!!.specifications.get(11).list.get(position)

            }else if(Constant.aparmentsize == 3){
                roomSize = jsonBaseClass!!.specifications.get(12).list.size.toInt()
                listData = jsonBaseClass!!.specifications.get(12).list.get(position)

            }else if(Constant.aparmentsize == 4){
                roomSize = jsonBaseClass!!.specifications.get(13).list.size.toInt()
                listData = jsonBaseClass!!.specifications.get(14).list.get(position)

            }
            var replceString = listData!!.name.toString().replace("[", "").replace("]", "");

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
                    RoomupdateView(totalcount, holder, position, listData!!.price,replceString)
                } else {
                    totalcount = 0
                    RoomupdateView(totalcount, holder, position, listData!!.price,replceString)
                }


            }
            holder.btn_minus.setOnClickListener {
                if (totalcount >= 0) {
                    totalcount -= 1
                    RoomupdateView(totalcount, holder, position, listData!!.price,replceString)
                } else {
                    totalcount = 0
                    RoomupdateView(totalcount, holder, position, listData!!.price,replceString)
                }
            }


        }
        if (categotyTag == "Kitchen" ) {
            var listData: ListData ? = null
            if(Constant.aparmentsize == 0){
                KitchenSize = jsonBaseClass!!.specifications.get(15).list.size.toInt()
                listData = jsonBaseClass!!.specifications.get(15).list.get(position)

            }else if(Constant.aparmentsize == 1){
                KitchenSize = jsonBaseClass!!.specifications.get(16).list.size.toInt()
                listData = jsonBaseClass!!.specifications.get(16).list.get(position)

            }else if(Constant.aparmentsize == 2){
                KitchenSize = jsonBaseClass!!.specifications.get(17).list.size.toInt()
                listData = jsonBaseClass!!.specifications.get(17).list.get(position)

            }else if(Constant.aparmentsize == 3){
                KitchenSize = jsonBaseClass!!.specifications.get(18).list.size.toInt()
                listData = jsonBaseClass!!.specifications.get(18).list.get(position)

            }else if(Constant.aparmentsize == 4){
                KitchenSize = jsonBaseClass!!.specifications.get(19).list.size.toInt()
                listData = jsonBaseClass!!.specifications.get(19).list.get(position)

            }
            var replceString = listData!!.name.toString().replace("[", "").replace("]", "");

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
                    KitchenupdateView(totalcount, holder, position, listData!!.price,replceString)
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
            string = jsonBaseClass!!.specifications.get(1).list.size.toInt().toString()
        }
        if (categotyTag == "Bathroom") {
            string = jsonBaseClass!!.specifications.get(6).list.size.toInt().toString()
        }
        if (categotyTag == "RoomView") {
            string =jsonBaseClass!!.specifications.get(9).list.size.toInt().toString()
        }
        if (categotyTag == "Kitchen") {
            string = jsonBaseClass!!.specifications.get(15).list.size.toInt().toString()
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
        var liMainView : LinearLayout

        init {
            txtcheckBOx = view.findViewById(R.id.txtcheckBOx)
            liCountView = view.findViewById(R.id.liCountView)
            txtCleanPrice = view.findViewById(R.id.txtCleanPrice)
            btn_plus = view.findViewById(R.id.btn_plus_checkBox)
            tv_item_count = view.findViewById(R.id.tv_item_count_checkBox)
            btn_minus = view.findViewById(R.id.btn_minus_checkBox)
            liMainView = view.findViewById(R.id.liMainView)


        }
    }


}
