package com.iqbalfa.newsapp.data.api.interceptor
import com.iqbalfa.newsapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class NewsApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalHttpUrl = originalRequest.url()

        val url = originalHttpUrl.newBuilder().addQueryParameter("apikey", BuildConfig.API_KEY).build()
        val requestBuilder = originalRequest.newBuilder().url(url)
        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}