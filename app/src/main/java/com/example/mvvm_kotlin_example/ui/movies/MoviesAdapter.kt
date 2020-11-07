package com.example.mvvm_kotlin_example.ui.movies

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_kotlin_example.databinding.MovieBinding
import com.example.mvvm_kotlin_example.model.Movie

/**
 * Created by Sarsenov Yerlan on 04.11.2020.
 */
class MoviesAdapter(var list: List<Movie>, var listener: OnItemClickListener) : RecyclerView.Adapter<MoviesHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesHolder =
        MoviesHolder(
            MovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MoviesHolder, position: Int) {
        val movie = list[position]
//        Log.e(this.javaClass.simpleName, "onBindViewHolder: ${movie.toString()}")
        holder.bind(movie)
        holder.itemView.setOnClickListener {
            listener.onClick(movie.title, movie.imdbId)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface OnItemClickListener {
        fun onClick(title: String,imdbId: String)
    }

}