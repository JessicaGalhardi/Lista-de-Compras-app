package com.example.tp1_ads_desenvolvimentokotlim

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ListAdapterCompras :  ListAdapter<Lista, ListAdapterCompras.ListaViewHolder>(ItensComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaViewHolder {
        return ListaViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ListaViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.produto)


    }

    //Nessa classe ocorre a vinculação dos dados ao TextView
    class ListaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val produtoItemView: TextView = itemView.findViewById(R.id.lbl_produto)


        fun bind(text: String?) {

            produtoItemView.text = text


        }

        companion object {

            fun create(parent: ViewGroup): ListaViewHolder {

                val view: View = LayoutInflater.from(parent.context).inflate(
                    R.layout.recyclerview_item, parent, false
                )
                return ListaViewHolder(view)
            }
        }


    }

    //Analisa se existem variáveis com o mesmo dado.
    class ItensComparator : DiffUtil.ItemCallback<Lista>() {

        override fun areItemsTheSame(oldItem: Lista, newItem: Lista): Boolean {
            return (oldItem === newItem)

        }

        override fun areContentsTheSame(oldItem: Lista, newItem: Lista): Boolean {

            return oldItem.produto == newItem.produto


        }
    }
}


