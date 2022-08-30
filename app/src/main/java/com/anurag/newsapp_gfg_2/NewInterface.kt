package com.anurag.newsapp_gfg_2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewInterface  {

        @GET("top-headlines")
    fun fetchHeadlines(@Query("country") country : String , @Query("apiKey") apikey: String):Call<News>

    // https://newsapi.org/v2/top-headlines?country=IN&apiKey=12345

}