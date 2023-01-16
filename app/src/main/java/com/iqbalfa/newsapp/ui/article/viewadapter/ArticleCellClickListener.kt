package com.iqbalfa.newsapp.ui.article.viewadapter

import com.iqbalfa.newsapp.data.api.response.Article

interface ArticleCellClickListener {
    fun onCellClickListener(data: Article)
}