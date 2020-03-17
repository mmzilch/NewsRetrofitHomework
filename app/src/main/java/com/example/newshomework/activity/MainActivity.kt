package com.example.newshomework.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newshomework.R
import com.example.newshomework.adapter.NewsAdapter
import com.example.newshomework.api.NewsApiInterface
import com.example.newshomework.model.Article
import com.example.newshomework.model.News
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_news.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNews()
    }

    fun getNews() {
        var BASE_URL = "http://newsapi.org/v2/"
        var retrofitPost = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        var retrofitService = retrofitPost.create(NewsApiInterface::class.java)
        var apiCall = retrofitService.getNews("us", "business", "8f39db3aa4ef40ea83d8ff29a4794ef4")

        apiCall.enqueue(object : Callback<News> {
            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("Failure>>>>>>", t.toString())

            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
                var newsData = response.body()?.articles
                Log.d("Articles>>>>>>",newsData.toString())

                rcyNews.layoutManager=LinearLayoutManager(this@MainActivity)
                rcyNews.adapter=NewsAdapter(newsData as ArrayList<Article>)

                var content = response.body()?.articles
                //tvContent.text=response.body().toString()

                // var a=response.body().article
                //var b=response.body().content
                // return array List and add to adapter
                //response.body() is new

            }
        })
    }
}
