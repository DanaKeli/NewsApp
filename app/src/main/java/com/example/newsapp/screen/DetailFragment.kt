package com.example.newsapp.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.view.get
import coil.load
import com.example.newsapp.data.News
import com.example.newsapp.databinding.FragmentDetailBinding
import com.example.newsapp.viewmodel.NewsViewModel


class DetailFragment(private val layout: LinearLayout) : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding: FragmentDetailBinding
        get() = _binding ?: throw Exception("Binding error")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    }

