package com.example.mvvm_kotlin_example.ui.movies

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_kotlin_example.databinding.MovieBinding
import com.example.mvvm_kotlin_example.model.Movie

/**
 * Created by Sarsenov Yerlan on 04.11.2020.
 */
class MoviesHolder(val binding: MovieBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(movie: Movie) {
        binding.vm = MovieListItemViewModel(movie)
        binding.executePendingBindings()
//        Log.e(this.javaClass.simpleName, "bind: ${movie.title}")
    }
}