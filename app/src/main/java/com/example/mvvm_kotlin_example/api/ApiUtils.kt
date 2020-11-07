package com.example.mvvm_kotlin_example.api

import com.example.mvvm_kotlin_example.BuildConfig
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Sarsenov Yerlan on 01.11.2020.
 */
object ApiUtils {
    private fun clientMD(): OkHttpClient {
        val builder: OkHttpClient.Builder = OkHttpClient().newBuilder()
        val interceptor = ApiKeyInterceptor()
        builder.addInterceptor(interceptor)
        if (!BuildConfig.BUILD_TYPE.contains("release")) {
            val log_interceptor = HttpLoggingInterceptor()
            log_interceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(log_interceptor)
        }
        val client = builder.build()
        return client
    }

    private fun clientM(): OkHttpClient {
        val builder: OkHttpClient.Builder = OkHttpClient().newBuilder()
        if (!BuildConfig.BUILD_TYPE.contains("release")) {
            val log_interceptor = HttpLoggingInterceptor()
            log_interceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(log_interceptor)
        }
        val client = builder.build()
        return client
    }

    private fun retrofitMD(): Retrofit {
        val gson = Gson()
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.MOVIE_DB_URL)
            .client(clientMD())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
        return retrofit
    }

    private fun retrofitM(): Retrofit {
        val gson = Gson()
        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.MOVIES_URL)
            .client(clientM())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
        return retrofit
    }

    fun apiMD(): MovieDetailApi = retrofitMD().create(MovieDetailApi::class.java)

    fun apiM(): MoviesApi = retrofitM().create(MoviesApi::class.java)

}
