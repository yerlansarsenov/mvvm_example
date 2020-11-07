package com.example.mvvm_kotlin_example.api

import com.example.mvvm_kotlin_example.BuildConfig
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * Created by Sarsenov Yerlan on 01.11.2020.
 */
class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request : Request = chain.request()
        val httpUrl: HttpUrl = request.url.newBuilder()
            .addQueryParameter("api_key", BuildConfig.API_KEY)
            .addQueryParameter("external_source", "imdb_id")
            .build()
        request = request.newBuilder().url(httpUrl).build()
        return chain.proceed(request)
    }
}