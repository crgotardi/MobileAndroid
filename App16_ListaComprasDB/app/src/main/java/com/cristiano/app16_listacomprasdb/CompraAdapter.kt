package com.cristiano.app16_listacomprasdb

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import java.net.URI

class CompraAdapter(var listaCompra: List<Compra>, var listener: CompraAdapterListener):RecyclerView.Adapter<CompraAdapter.ItemViewHolder>() {
    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val txtCompra: TextView = view.findViewById(R.id.txtCompra)
        val btnExcluir: ImageButton = view.findViewById(R.id.btnExcluir)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_compra, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.txtCompra.text = listaCompra[position].nome
        holder.btnExcluir.setOnClickListener(){
            listener.excluirCompra(listaCompra[position])
        }
    }

    override fun getItemCount(): Int {
        return listaCompra.size
    }

    fun refreshListCompra(listaAtualizada: List<Compra>){
        listaCompra = listaAtualizada
        notifyDataSetChanged()
    }
}