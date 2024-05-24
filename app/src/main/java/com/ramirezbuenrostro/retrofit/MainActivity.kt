package com.ramirezbuenrostro.retrofit

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ramirezbuenrostro.retrofit.api.RetrofitFactory
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var recycler: RecyclerView
    lateinit var adapter: itemViewAdapter
    private val itemViewModel:itemViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler=findViewById(R.id.rvPrincipal)
        adapter= itemViewAdapter(itemViewModel.elementos)
        recycler.adapter=adapter

        recycler.layoutManager= LinearLayoutManager(this)
        buscar()

    }



    private fun buscar(){

        lifecycleScope.launch {
            try {
                val call= RetrofitFactory.getRetrofit()
                val salida=call.extraerDatos("")
                for (i in 0..salida.data.size-1){
                    itemViewModel.elementos.add(Item(salida.data[i].image,salida.data[i].name,salida.data[i].category))
                    println(salida.data[i].image)
                }
                adapter.notifyDataSetChanged()
            }catch (ex:Exception){
                Toast.makeText(this@MainActivity,"${ex.message}",Toast.LENGTH_SHORT).show()
            }
        }
        //CoroutineScope (Dispatchers.IO).launch{
        //val call= RetrofitFactory.getRetrofit()

        //runOnUiThread {
        //    if(call.isSuccessful){
        //        Toast.makeText(this@MainActivity,"Jalo", Toast.LENGTH_SHORT).show()
        //    }else Toast.makeText(this@MainActivity,"Ha ocurrido un error", Toast.LENGTH_SHORT).show()
        //}
        //}
    }
}