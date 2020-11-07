package com.example.mvvm_kotlin_example.api

import com.example.mvvm_kotlin_example.model.MovieDetails
import io.reactivex.Single
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Sarsenov Yerlan on 01.11.2020.
 */
interface MovieDetailApi {

    @GET("find/{id}")
    fun getDetailById(@Path("id") id: String): Deferred<MovieDetails>

}