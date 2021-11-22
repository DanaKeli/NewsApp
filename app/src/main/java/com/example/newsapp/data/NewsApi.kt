package com.example.newsapp.data

import android.util.Log
import com.squareup.moshi.Json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("v4/search?q=ru&token=a0c785c8896f25434c7b533de9ecc9eb")
    suspend fun getAllNew(): ApiData
}

object NewsApiImplementation {
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create())
        .baseUrl("https://gnews.io/api/")
        .build()


    private val newsAPIService = retrofit.create(NewsApi::class.java)

    suspend fun getAllNews(): List<News> {
        val res = withContext(Dispatchers.IO) {
            newsAPIService.getAllNew()
                .articles
                .map { article ->
                    News(
                        article.title,
                        article.description,
                        article.content,
                        article.url,
                        article.image,
                        article.time
                    )
                }
        }
        return res
    }
}
