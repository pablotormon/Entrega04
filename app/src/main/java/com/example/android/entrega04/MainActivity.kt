package com.example.android.entrega04

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import com.example.android.entrega04.data.PizzaListAdapter
import com.example.android.entrega04.model.Pizza

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {


    private var adapter: PizzaListAdapter? = null
    private var pizzaList: ArrayList<Pizza>? = null
    private var layoutManager:RecyclerView.LayoutManager?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setSupportActionBar(toolbar)

        pizzaList = ArrayList<Pizza>()
        layoutManager = LinearLayoutManager(this)
        adapter = PizzaListAdapter(pizzaList!!, this)

        miRecyclerView.layoutManager = layoutManager
        miRecyclerView.adapter = adapter

        addData()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun addData(){

        var pizzaNameList: Array<String> = arrayOf("Margarita", "Cuatro Quesos","Carbonara","Barbacoa", "Diávola", "Cuatro estaciones")
        var pizzaIngredientesList: Array<String> = arrayOf("Tomate, mozzarella y albahaca fresca", "Mozzarella, provolone, parmesano y emmental",
            "Yema de huevo, huevo duro, manteca de cerdo, aceite y pimienta negra","Carne de ternera, trozos de pollo, cebolla, tomate, bacon, mozzarella y salsa barbacoa",
            "Chorizo picante, salami y salsa picante", "Jamon, alcachofas, champiñones y olivas")
        var pizzaImages: Array<Int> = arrayOf(R.drawable.margarita, R.drawable.cuatro, R.drawable.carbonara,R.drawable.barbacoa,R.drawable.diavola,R.drawable.estaciones)



        for (i in 0..(pizzaNameList.size-1)){

            var pizza = Pizza()
            pizza.pizzaName = pizzaNameList[i]
            pizza.pizzaIngredients = pizzaIngredientesList[i]
            pizza.pizzaImage = pizzaImages[i]
            pizzaList!!.add(pizza)
            println(pizzaNameList[i])
        }




    }
}
