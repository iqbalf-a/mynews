package com.iqbalfa.newsapp.ui.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.iqbalfa.newsapp.data.api.response.Article
import com.iqbalfa.newsapp.data.repository.NewsRepository

class ArticleViewModel(private val newsRepository: NewsRepository) : ViewModel() {
    fun getArticleBySource(sourceId: String): LiveData<PagingData<Article>> {
        return newsRepository.getNewsBySourcePaging(sourceId)
    }
}