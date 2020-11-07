package com.example.mvvm_kotlin_example.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Sarsenov Yerlan on 01.11.2020.
 */

data class MovieResult(
    @SerializedName("adult") val adult : Boolean,
    @SerializedName("backdrop_path") val backdrop_path : String,
    @SerializedName("original_title") val original_title : String,
    @SerializedName("overview") val overview : String,
    @SerializedName("release_date") val release_date : String,
    @SerializedName("poster_path") val poster_path : String,
    @SerializedName("title") val title : String,
    @SerializedName("vote_average") val vote_average : Double,
)