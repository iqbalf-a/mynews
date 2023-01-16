package com.iqbalfa.newsapp.data.api

import com.iqbalfa.newsapp.data.api.response.NewsResponse
import com.iqbalfa.newsapp.data.api.response.NewsSourceResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("everything")
    suspend fun getTopHeadLineNews(
        @Query("sources") source: String,
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): Response<NewsResponse>

    @GET("sources")
    suspend fun getSourceByCategory(
        @Query("category") category: String,
    ): Response<NewsSourceResponse>
}