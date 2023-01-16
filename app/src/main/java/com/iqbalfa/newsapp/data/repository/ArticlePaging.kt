package com.iqbalfa.newsapp.data.repository

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.iqbalfa.newsapp.data.api.NewsApi
import com.iqbalfa.newsapp.data.api.response.Article
import java.lang.Exception

class ArticlePaging(private val source: String, private val service: NewsApi) :
    PagingSource<Int, Article>() {
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val pageNumber = params.key ?: 1
        return try {
            val response = service.getTopHeadLineNews(source, pageNumber, 15)
            var nextKey: Int? = null
            if (response.isSuccessful) {
                response.body()?.let {
                    nextKey = if (response.body()!!.articles.isEmpty()) {
                        null
                    } else {
                        pageNumber + 1
                    }
                }
                Log.d("Next key Article", nextKey.toString())
            }
            return LoadResult.Page(
                data = response.body()!!.articles,
                prevKey = null,
                nextKey = nextKey
            )
        } catch (e: Exception) {
            e.message?.let { Log.d("Error Exception", it) }
            LoadResult.Error(e)
        }
    }


}