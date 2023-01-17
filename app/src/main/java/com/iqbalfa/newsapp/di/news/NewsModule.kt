package com.iqbalfa.newsapp.di.news

import com.iqbalfa.newsapp.data.repository.NewsRepository
import com.iqbalfa.newsapp.data.repository.NewsRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface NewsModule {
    @Binds
    abstract fun bindsNewsModule(newsRepositoryImpl: NewsRepositoryImpl): NewsRepository
}