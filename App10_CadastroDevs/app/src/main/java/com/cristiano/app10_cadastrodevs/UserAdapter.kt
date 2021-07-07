package com.cristiano.app10_cadastrodevs

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(var listUser: MutableList<User>, var context: Context):RecyclerView.Adapter<UserAdapter.ItemViewHolder>() {
    class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imgFoto: ImageView = view.findViewById(R.id.imgFoto)
        val txtNome: TextView = view.findViewById(R.id.txtNome)
        val txtStack: TextView = view.findViewById(R.id.txtStack)
        val txtNivel: TextView = view.findViewById(R.id.txtNivel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        listUser[position].foto?.let{
            holder.imgFoto.setImageBitmap(it)
        }
        holder.txtNome.text = listUser[position].nome
        holder.txtStack.text = listUser[position].stack.nome
        holder.txtNivel.text = listUser[position].nivel.nome

        holder.itemView.setOnClickListener(){
            var texto = if (listUser[position].empregado) {
                "Dev no mercado de trabalho"
            }
            else
            {
                "Dev aberto a oportunidades"
            }

            Toast.makeText(context, texto, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return listUser.size
    }
}

