package com.example.android.entrega04.model

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.android.entrega04.R
import kotlinx.android.synthetic.main.activity_final.*

class FinalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        var nombrePizza = intent.getStringExtra("nombrePizza")
        var tamañoPizza = intent.getStringExtra("tamañoPizza")
        var ingredientesPizza = intent.getStringArrayListExtra("ingredientesPizza")
        var bebidasPizza = intent.getStringArrayListExtra("bebidasPizza")
        var precio = intent.getStringExtra("precio")

        final_mombre.text = nombrePizza
        final_tamaño.text = "tu pizza $tamañoPizza"
        dinero.text=precio

        if (ingredientesPizza.isEmpty()){ final_con.visibility = View.GONE
            final_ingredientes.visibility =View.GONE}
        else {
            var text01: String = String()
            for (i in ingredientesPizza){text01 += "$i \n"}
            final_ingredientes.text = text01
        }

        if (bebidasPizza.isEmpty()){ final_ytu.visibility = View.GONE
            final_bebida.visibility =View.GONE}
        else {
            var text02: String = String()
            for (i in bebidasPizza){text02 += "$i \n"}
            final_bebida.text = text02
        }


    }
}
