package com.example.mvvm_kotlin_example.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Sarsenov Yerlan on 01.11.2020.
 */
data class MovieDetails(
    @SerializedName("movie_results") val movie_results : List<MovieResult>,
)