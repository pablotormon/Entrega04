package com.example.android.entrega04.model

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import com.example.android.entrega04.R
import kotlinx.android.synthetic.main.activity_final.*
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity : AppCompatActivity() {

    var precioFinal = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        //actionBar.hide()
        var nombrePizza = intent.getStringExtra("nombrePizza")

        form_imageView.setImageResource(intent.getIntExtra("imagenPizza",R.drawable.barbacoa))
        form_nombrePizza.text = nombrePizza

        SwichOlivas.setOnCheckedChangeListener { _, isChecked -> estaTildado(isChecked, 2)}
        SwitchPeperoni.setOnCheckedChangeListener { _, isChecked -> estaTildado(isChecked, 2)}
        SwitchHuevo.setOnCheckedChangeListener { _, isChecked -> estaTildado(isChecked, 2)}
        SwitchJamon.setOnCheckedChangeListener { _, isChecked -> estaTildado(isChecked, 2)}
        SwitchPepino.setOnCheckedChangeListener { _, isChecked -> estaTildado(isChecked, 2)}
        SwitchPollo.setOnCheckedChangeListener { _, isChecked -> estaTildado(isChecked, 2)}

        form_tamano_01.setOnCheckedChangeListener { _, isChecked -> estaTildado(isChecked, 15)}
        form_tamano_02.setOnCheckedChangeListener { _, isChecked -> estaTildado(isChecked, 20)}
        form_tamano_03.setOnCheckedChangeListener { _, isChecked -> estaTildado(isChecked, 23)}

        checkBoxAgua.setOnCheckedChangeListener { _, isChecked -> estaTildado(isChecked, 2)}
        checkBoxPepsi.setOnCheckedChangeListener { _, isChecked -> estaTildado(isChecked, 3)}
        checkBoxCerveza.setOnCheckedChangeListener { _, isChecked -> estaTildado(isChecked, 4)}

        form_boton.setOnClickListener {

            var finalIntent = Intent(this, FinalActivity::class.java)
            finalIntent.putExtra("nombrePizza", nombrePizza.toString())
            finalIntent.putExtra("tamañoPizza", tamañoPizza())
            finalIntent.putExtra("ingredientesPizza", ingredieentesElegidos())
            finalIntent.putExtra("bebidasPizza", bebidasElegidas())
            finalIntent.putExtra("precio", form_precio.text)

            startActivity(finalIntent)}


        }


    fun estaTildado(tildado: Boolean, coste: Int){

        if (tildado){precioFinal +=coste} else {precioFinal -= coste}
        form_precio.text = precioFinal.toString() + " €"

    }

    fun tamañoPizza():String {

        if (form_tamano_01.isChecked){return "pequeña"}
        else if (form_tamano_02.isChecked){return "mediana"}
        else {return "familiar"}
    }

    fun ingredieentesElegidos():ArrayList<String>{

        var listaIngredientes = ArrayList<String>()

        if (SwichOlivas.isChecked){listaIngredientes.add("Olivas")}
        if (SwitchHuevo.isChecked){listaIngredientes.add("Huevo Frito")}
        if (SwitchJamon.isChecked){listaIngredientes.add("Jamón")}
        if (SwitchPeperoni.isChecked){listaIngredientes.add("Peperoni")}
        if (SwitchPepino.isChecked){listaIngredientes.add("Piña")}
        if (SwitchPollo.isChecked){listaIngredientes.add("Pollo")}

        return listaIngredientes

    }

    fun bebidasElegidas():ArrayList<String>{

        var listaBebidas= ArrayList<String>()

        if (checkBoxAgua.isChecked){listaBebidas.add("Agua")}
        if (checkBoxCerveza.isChecked){listaBebidas.add("Cerveza")}
        if (checkBoxPepsi.isChecked){listaBebidas.add("Pepsi")}

        return listaBebidas

    }
}
