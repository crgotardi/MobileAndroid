package com.cristiano.app8_pets

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rvPets)

        val lista = mutableListOf<Pet>(
            Pet(especie="Cão", nome="Izzie", foto=resources.getDrawable(R.drawable.izzie)),
        )

        rv.adapter = PetAdapter(lista)
        rv.layoutManager = LinearLayoutManager(this)
    }
}