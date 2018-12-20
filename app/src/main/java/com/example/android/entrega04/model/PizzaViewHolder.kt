package com.example.android.entrega04.model

import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.android.entrega04.R

class PizzaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun bindItem(pizza: Pizza){

        var nombre: TextView = itemView.findViewById(R.id.miPizza) as TextView
        var ingredients: TextView = itemView.findViewById(R.id.miIngredientes) as TextView
        var imagen: ImageView = itemView.findViewById(R.id.miImageView)

        nombre.text = pizza.pizzaName
        ingredients.text = pizza.pizzaIngredients
        imagen.setImageResource(pizza.pizzaImage!!)

        itemView.setOnClickListener {

            var formIntent = Intent(itemView.context, FormActivity::class.java)
            formIntent.putExtra("nombrePizza", pizza.pizzaName.toString())
            formIntent.putExtra("imagenPizza", pizza.pizzaImage!!)
            itemView.context.startActivity(formIntent)

        }


    }



}