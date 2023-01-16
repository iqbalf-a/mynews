package com.iqbalfa.newsapp.data.api

import com.iqbalfa.newsapp.data.api.interceptor.NewsApiKeyInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {

    val retrofit by lazy{
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(NewsApiKeyInterceptor())
        Retrofit.Builder()
            .baseUrl("http://newsapi.org/v2/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(httpClient.build())
            .build()
            .create(NewsApi::class.java)
    }
}