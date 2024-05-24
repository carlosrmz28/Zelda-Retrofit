package com.ramirezbuenrostro.retrofit.api

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Url
import com.ramirezbuenrostro.retrofit.api.data.zeldaResult

interface zeldaApi {
    @GET
    suspend fun extraerDatos(@Url url:String): zeldaResult
}

object RetrofitFactory{
    fun getRetrofit(): zeldaApi {
        return Retrofit.Builder()
            .baseUrl("https://botw-compendium.herokuapp.com/api/v3/compendium/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(zeldaApi::class.java)
    }

}