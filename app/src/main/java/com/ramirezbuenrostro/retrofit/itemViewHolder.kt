package com.ramirezbuenrostro.retrofit

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class itemViewHolder(vista: View): RecyclerView.ViewHolder(vista) {
    val image=vista.findViewById<ImageView>(R.id.imagen)
    var name=vista.findViewById<TextView>(R.id.nombre)
    var desc=vista.findViewById<TextView>(R.id.descripcion)
}