package com.example.mvvm_kotlin_example.ui.movie_detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_kotlin_example.databinding.MovieDetailBinding
import com.example.mvvm_kotlin_example.ui.BaseFragment

/**
 * Created by Sarsenov Yerlan on 05.11.2020.
 */
class MovieDetailFragment : BaseFragment() {

    val titleKey = "TITLE"
    val imdbIdKey = "IMDB_KEY"

    companion object {
        @JvmStatic
        fun newInstance(title: String, imdbId: String) = MovieDetailFragment().apply {
            arguments = Bundle().apply {
                putString(titleKey, title)
                putString(imdbIdKey, imdbId)
            }
        }
    }

    override val title: String
        get() = arguments?.getString(titleKey)!!
    val id: String
        get() = arguments?.getString(imdbIdKey)!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModel: MovieDetailViewModel by lazy { ViewModelProvider(this, MovieVMFactory(id)).get(MovieDetailViewModel::class.java) }
        val binding = MovieDetailBinding.inflate(inflater, container, false)
        binding.vm = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

}