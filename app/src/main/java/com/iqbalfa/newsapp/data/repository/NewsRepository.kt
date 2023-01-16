package com.iqbalfa.newsapp.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagingData
import com.iqbalfa.newsapp.data.api.response.Article
import com.iqbalfa.newsapp.data.api.response.Source
import java.util.Locale.Category

interface NewsRepository {
    fun getNewsBySourcePaging(source: String): LiveData<PagingData<Article>>

    suspend fun getNewsSourceByCategory(category: String): List<Source>
}