package com.iqbalfa.newsapp.di.ui

import com.iqbalfa.newsapp.ui.MainActivity
import com.iqbalfa.newsapp.ui.article.ArticleActivity
import com.iqbalfa.newsapp.ui.newssource.NewsSourceActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivitiesModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributeArticleActivity(): ArticleActivity

    @ContributesAndroidInjector
    abstract fun contributeNewsSurceActivity(): NewsSourceActivity
}