package com.example.cartmanagementapp_demo.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cartmanagementapp_demo.Activity.MainActivity_ViewModel
import com.example.cartmanagementapp_demo.R
import com.example.cartmanagementapp_demo.Roomdatabase.CartModel
import com.example.cartmanagementapp_demo.Roomdatabase.CartViewmodel
import com.example.cartmanagementapp_demo.Utils.Constant
import com.example.cartmanagementapp_demo.Utils.Constant.Companion.CartCountPrice
import com.example.cartmanagementapp_demo.Utils.Constant.Companion.TotolPrice
import com.example.cartmanagementapp_demo.Utils.Constant.Companion.cartCurrentposion
import com.example.cartmanagementapp_demo.Utils.Constant.Companion.iscartcountclick
import kotlinx.android.synthetic.main.cart_item_layout.view.*

class CartAdapter(var list: List<CartModel>, val viewModel: CartViewmodel) :
    RecyclerView.Adapter<CartAdapter.CartViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.cart_item_layout, parent, false)
        return CartViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        var currentPosition = list[position]
        holder.itemView.txtCustomiseSubtitle.text = currentPosition.itemName


        holder.itemView.txtAddOrderPrice.text = "${currentPosition.itemPrice}"

        holder.itemView.tv_item_count_bottom.text ="${currentPosition.IteamCount}"



        holder.itemView.ivCancle.setOnClickListener {
            viewModel.delete(currentPosition)
        }

//        To get total cost
        var totalcount: Int = 1


        Log.e("dhruvtest", "--count--" + currentPosition.IteamCount)

        holder.btn_plus.setOnClickListener {

            currentPosition.IteamCount++
            viewModel.update(currentPosition)

            viewModel.getCartCountUpdate(currentPosition)



        }

        holder.btn_minus.setOnClickListener {

            currentPosition.IteamCount--

            viewModel.update(currentPosition)
            viewModel.getCartCountUpdate(currentPosition)

        }



        holder.itemView.ivCancle.setOnClickListener {
            viewModel.delete(currentPosition)
        }


    }

    fun ButtonupdateView(count : Int,holder: CartViewHolder) {


        //  Constant.CartItemCount = totalcount


        //Log.e("dhruvTest", "-position-" + position.toString())

        // viewModel!!.getCartCountUpdate(totalcount, finalprice, position)

    }

    inner class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var btn_plus: AppCompatButton
        var btn_minus: AppCompatButton
        var tv_item_count: AppCompatTextView


        init {

            btn_plus = itemView.findViewById(R.id.btn_plus_bottom)
            tv_item_count = itemView.findViewById(R.id.tv_item_count_bottom)
            btn_minus = itemView.findViewById(R.id.btn_minus_bottom)


        }

    }
}