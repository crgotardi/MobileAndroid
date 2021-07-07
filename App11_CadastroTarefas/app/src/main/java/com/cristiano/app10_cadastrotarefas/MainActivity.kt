package com.cristiano.app10_cadastrotarefas

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var tarefaAdapter: TarefaAdapter
    lateinit var btnIncluir: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle(R.string.titulo_lista)

        val rv = findViewById<RecyclerView>(R.id.rvTarefas)
        tarefaAdapter = TarefaAdapter(lista, this)
        btnIncluir = findViewById(R.id.btnIncluir)
        rv.adapter = tarefaAdapter

        btnIncluir.setOnClickListener(){
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }

        rv.layoutManager = LinearLayoutManager(this)
    }

    companion object{
        val lista = mutableListOf<Tarefa>()
    }

    override fun onResume() {
        super.onResume()
        tarefaAdapter.notifyDataSetChanged()
    }
}