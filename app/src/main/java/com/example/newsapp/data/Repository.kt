package com.example.newsapp.data

class Repository {
    suspend fun getMoreNews() = NewsApiImplementation.getAllNews()
}