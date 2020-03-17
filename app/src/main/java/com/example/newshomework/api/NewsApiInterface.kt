package com.example.newshomework.api

import com.example.newshomework.model.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiInterface {

    @GET("top-headlines")
    fun getNews(
        @Query("country")
        country : String,
        @Query("category")
        category:String,
        @Query("apiKey")
        apiKey:String
    ): Call<News>

}