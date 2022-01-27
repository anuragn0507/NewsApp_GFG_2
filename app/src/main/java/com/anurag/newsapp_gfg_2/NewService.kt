package com.anurag.newsapp_gfg_2

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//Singleton object (we need to create the object again and again we can create this object in any class)

object NewService {
    private val retrofit = Retrofit.Builder()
       .baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val newInstance: NewInterface = retrofit.create(NewInterface :: class.java)
}