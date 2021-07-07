package com.cristiano.app10_cadastrodevs

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var userAdapter: UserAdapter
    lateinit var btnIncluir: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTitle(R.string.list_title)

        val rv = findViewById<RecyclerView>(R.id.rvUsuarios)
        userAdapter = UserAdapter(lista, this)
        btnIncluir = findViewById(R.id.btnIncluir)

        rv.adapter = userAdapter

        btnIncluir.setOnClickListener(){
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        rv.layoutManager = LinearLayoutManager(this)
    }

    companion object{
        val lista = mutableListOf<User>()
    }

    override fun onResume() {
        super.onResume()
        userAdapter.notifyDataSetChanged()
    }
}