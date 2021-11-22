package com.example.newsapp.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

class ApiData(
    @Json(name = "totalArticles")val totalArticles: Int,
    @Json(name = "articles") val articles: List<News>
)

class News(
    @Json(name = "title") val title: String?,
    @Json(name = "description") val description: String?,
    @Json(name = "content") val content: String?,
    @Json(name = "url") val url: String?,
    @Json(name = "image") val image: String?,
    @Json(name = "publishedAt") val time: String?
)
