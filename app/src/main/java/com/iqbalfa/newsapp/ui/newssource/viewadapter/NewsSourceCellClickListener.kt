package com.iqbalfa.newsapp.ui.newssource.viewadapter

import com.iqbalfa.newsapp.data.api.response.Source

interface NewsSourceCellClickListener {
    fun onCellClickListener(data: Source)
}