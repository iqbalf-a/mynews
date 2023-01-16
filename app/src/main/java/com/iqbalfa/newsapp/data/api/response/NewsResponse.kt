package com.iqbalfa.newsapp.data.api.response

data class NewsResponse(
    val status: String,
    val totalResult: Int,
    val articles: List<Article>
)
