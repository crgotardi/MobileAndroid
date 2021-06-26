package com.cristiano.app9_listatarefas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rvTarefas)

        val lista = mutableListOf<Tarefa>(
            Tarefa(titulo="Tarefa 1", descricao="Uma descrição mt louca aqui"),
            Tarefa(titulo="Tarefa 2", descricao="Uma descrição mt louca aqui"),
            Tarefa(titulo="Tarefa 3", descricao="Uma descrição mt louca aqui")
        )

        rv.adapter = TarefaAdapter(lista)
        rv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    }
}