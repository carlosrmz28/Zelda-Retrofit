package com.ramirezbuenrostro.retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class itemViewAdapter(val items:List<Item>): RecyclerView.Adapter<itemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        val vista= LayoutInflater.from(parent.context).inflate(
            R.layout.item_zelda,
            parent,
            false
        )
        return itemViewHolder(vista)
    }

    override fun getItemCount(): Int=items.size

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        holder.name.text=items[position].nombre
        holder.desc.text=items[position].desc
        try{
            Picasso.get().load(items[position].image).into(holder.image)
        }catch (ex: Exception){
            println("Error")
        }
    }
}