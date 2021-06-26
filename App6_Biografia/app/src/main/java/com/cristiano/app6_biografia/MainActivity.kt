package com.cristiano.app6_biografia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btnSobre : Button
    private lateinit var btnFormacao : Button
    private lateinit var btnExperiencia : Button
    private lateinit var btnObjetivo : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSobre = findViewById(R.id.btnSobre)
        btnFormacao = findViewById(R.id.btnFormacao)
        btnExperiencia = findViewById(R.id.btnExperiencia)
        btnObjetivo = findViewById(R.id.btnObjetivo)

        btnSobre.setOnClickListener {
            val intentSobre = Intent(this@MainActivity, SobreActivity::class.java)
            startActivity(intentSobre)
        }

        btnFormacao.setOnClickListener {
            val intentFormacao = Intent(this@MainActivity, FormacaoActivity::class.java)
            startActivity(intentFormacao)
        }

        btnExperiencia.setOnClickListener {
            val intentExperiencia = Intent(this@MainActivity, ExperienciaActivity::class.java)
            startActivity(intentExperiencia)
        }

        btnObjetivo.setOnClickListener {
            val intentObjetivo = Intent(this@MainActivity, ObjetivoActivity::class.java)
            startActivity(intentObjetivo)
        }
    }
}