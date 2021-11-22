package com.example.newsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.News
import com.example.newsapp.data.NewsApiImplementation
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {


    private val _items = MutableLiveData<List<News>>()
    private val items: LiveData<List<News>> get() = _items

    init {
        viewModelScope.launch {
            _items.value = NewsApiImplementation.getAllNews()
        }
    }

    fun getAllNews(): LiveData<List<News>> {
        return items
    }

}