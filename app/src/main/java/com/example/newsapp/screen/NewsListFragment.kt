package com.example.newsapp.screen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.add
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.adapters.NewsAdapter
import com.example.newsapp.data.ApiData
import com.example.newsapp.data.News
import com.example.newsapp.data.NewsApiImplementation
import com.example.newsapp.data.Repository
import com.example.newsapp.databinding.FragmentNewsListBinding
import com.example.newsapp.viewmodel.NewsViewModel
import com.squareup.moshi.Json
import kotlinx.coroutines.runBlocking


class NewsListFragment : Fragment() {

    private var _binding: FragmentNewsListBinding? = null
    private val binding: FragmentNewsListBinding
        get() = _binding ?: throw Exception("Binding error")

    private var newsList: ArrayList<News> = arrayListOf()

    private val viewModel: NewsViewModel by viewModels()

    private val onItemClick: (item: LinearLayout) -> Unit = {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.mainContainer, DetailFragment(it))
            .addToBackStack(null)
            .commit()
    }

    private val adapter = NewsAdapter(onItemClick)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvNewsList.adapter = adapter
        binding.rvNewsList.layoutManager = LinearLayoutManager(context)

        viewModel.getAllNews().observe(viewLifecycleOwner, {
            if (it.isNotEmpty()) {
                newsList.addAll(it)
                adapter.submitList(newsList.toList())
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}