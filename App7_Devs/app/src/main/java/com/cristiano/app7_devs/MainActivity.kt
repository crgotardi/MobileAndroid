package com.cristiano.app7_devs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rvUsuarios)

        val lista = mutableListOf<Usuario>(
            Usuario(nome="User 1", email="user1@mail.com", foto=resources.getDrawable(R.drawable.avatar)),
            Usuario(nome="User 2", email="user2@mail.com", foto=resources.getDrawable(R.drawable.avatar)),
            Usuario(nome="User 3", email="user3@mail.com", foto=resources.getDrawable(R.drawable.avatar))
        )

        rv.adapter = UsuarioAdapter(lista)
        rv.layoutManager = LinearLayoutManager(this)
    }
}