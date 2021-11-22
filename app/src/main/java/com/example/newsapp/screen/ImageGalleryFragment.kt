package com.example.newsapp.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsapp.databinding.FragmentImageGalleryBinding
import java.lang.Exception

class ImageGalleryFragment : Fragment() {

    private var _binding: FragmentImageGalleryBinding? = null
    private val binding: FragmentImageGalleryBinding
    get() = _binding ?: throw Exception("Binding error")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentImageGalleryBinding.inflate(inflater, container,  false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}