package com.cristiano.app10_cadastrotarefas

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import java.net.URI

class TarefaAdapter(var listaTarefa: MutableList<Tarefa>, var context: Context):RecyclerView.Adapter<TarefaAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imgFoto: ImageView = view.findViewById(R.id.imgFoto)
        val txtTitulo: TextView = view.findViewById(R.id.txtTitulo)
        val txtDescricao: TextView = view.findViewById(R.id.txtDescricao)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tarefa, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        listaTarefa[position].foto?.let{
            holder.imgFoto.setImageBitmap(it)
        }
        holder.txtTitulo.text = listaTarefa[position].titulo
        holder.txtDescricao.text = listaTarefa[position].descricao

        holder.itemView.setOnClickListener(){
            var texto = if (listaTarefa[position].finalizado) {
                "Tarefa finalizada!"
            }
            else
            {
                "Ainda em progresso!"
            }

            Toast.makeText(context, texto, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return listaTarefa.size
    }
}