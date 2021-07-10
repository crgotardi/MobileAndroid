package com.cristiano.app16_listacomprasdb

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity(), CompraAdapterListener {

    lateinit var compraAdapter: CompraAdapter
    lateinit var edtCompra: EditText
    lateinit var btnIncluir: ImageButton
    lateinit var preferenciasCompra: SharedPreferences
    lateinit var rv: RecyclerView

    var db: AppDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preferenciasCompra = getSharedPreferences("compraPreferences", Context.MODE_PRIVATE)
        rv = findViewById<RecyclerView>(R.id.rvCompras)

        btnIncluir = findViewById(R.id.btnIncluir)
        edtCompra = findViewById(R.id.edtCompra)

        btnIncluir.setOnClickListener() {
            if (edtCompra.text.toString().isNotEmpty()) {
                adicionarCompra(edtCompra.text.toString())
                edtCompra.text.clear()

                val editor = preferenciasCompra.edit()
                editor.remove("NOME")
                editor.commit()
            } else {
                edtCompra.error = "Insira um texto válido!"
            }
        }
    }

    fun adicionarCompra(nomeCompra: String) {

        CoroutineScope(Dispatchers.IO).launch {

            db = DatabaseBuilder.getAppDatabase(this@MainActivity)
            db?.compraDao()?.addCompras(Compra(nome = nomeCompra))

            val compraDAO = db?.compraDao()
            val resposta = compraDAO?.getCompras()

            withContext(Dispatchers.Main) {
                resposta?.let {
                    compraAdapter.refreshListCompra(resposta)
                }
            }
        }
    }

    fun recuperarLista(){

        CoroutineScope(Dispatchers.IO).launch {

            db = DatabaseBuilder.getAppDatabase(this@MainActivity)

            val compraDAO = db?.compraDao()
            val resposta = compraDAO?.getCompras()

            withContext(Dispatchers.Main){
                resposta?.let{
                    compraAdapter = CompraAdapter(it, this@MainActivity)
                    rv.adapter = compraAdapter
                    rv.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()

        if (edtCompra.text.toString().isNotEmpty()){
            val editor = preferenciasCompra.edit()
            editor.putString("NOME", edtCompra.text.toString())
            editor.commit()
        }
    }

    override fun onResume() {
        super.onResume()
        edtCompra.setText(preferenciasCompra.getString("NOME", null))
    }

    override fun onStart() {
        super.onStart()
        recuperarLista()
    }

    override fun excluirCompra(compra: Compra) {

        CoroutineScope(Dispatchers.IO).launch {
            db = DatabaseBuilder.getAppDatabase(this@MainActivity)
            db?.compraDao()?.deleteCompra(compra)
            val compraDAO = db?.compraDao()
            val resposta = compraDAO?.getCompras()

            withContext(Dispatchers.Main) {
                resposta?.let {
                    compraAdapter.refreshListCompra(resposta)
                    Toast.makeText(this@MainActivity, "Compra deletada", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}