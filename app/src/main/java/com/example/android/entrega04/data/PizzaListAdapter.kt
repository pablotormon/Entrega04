package com.example.android.entrega04.data

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.android.entrega04.R
import com.example.android.entrega04.model.Pizza
import com.example.android.entrega04.model.PizzaViewHolder

class PizzaListAdapter (private val list: ArrayList<Pizza>, private val context: Context): RecyclerView.Adapter<PizzaViewHolder>() {



    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PizzaViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.card_layout,p0, false)
        return PizzaViewHolder(view)
    }



    override fun getItemCount(): Int {

        return list.size
    }

    override fun onBindViewHolder(p0: PizzaViewHolder, p1: Int) {

        p0.bindItem(list[p1])
    }


}