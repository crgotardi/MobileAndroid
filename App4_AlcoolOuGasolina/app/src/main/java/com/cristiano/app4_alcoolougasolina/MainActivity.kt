package com.cristiano.app4_alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var btnCalcular: Button
    lateinit var txtResultado: TextView
    var precoAlcool: Double? = null
    var precoGasolina: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular = findViewById(R.id.btnCalcular)
        txtResultado = findViewById(R.id.txtResultado)
        btnCalcular.setOnClickListener {
            precoAlcool = findViewById<EditText>(R.id.edtPrecoAlcool).text.toString().toDoubleOrNull()
            precoGasolina = findViewById<EditText>(R.id.edtPrecoGasolina).text.toString().toDoubleOrNull()

            //CalcularMelhorCombustivel(precoAlcool, precoGasolina)
            CalcularMelhorCombustivel2()
        }
    }

    fun CalcularMelhorCombustivel2(){
        var calculo: Double? = 0.00

        if (precoAlcool != null && precoGasolina != null){
            calculo = precoAlcool?.div(precoGasolina!!)

            calculo?.let{
                if (it <= 0.7)
                    txtResultado.text = "Melhor utilizar Álcool"
                else
                    txtResultado.text = "Melhor utilizar Gasolina"
            }
        }
    }

    fun CalcularMelhorCombustivel(precoAlc: Double?, precoGas: Double?){
        var calculo: Double? = 0.00

        if (precoAlc != null && precoGas != null){
            calculo = precoAlc.div(precoGas)

            if (calculo <= 0.7)
                txtResultado.text = "Melhor utilizar Álcool"
            else
                txtResultado.text = "Melhor utilizar Gasolina"
        }
    }


}