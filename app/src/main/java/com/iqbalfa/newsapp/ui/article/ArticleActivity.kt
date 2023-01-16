package com.iqbalfa.newsapp.ui.article

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.iqbalfa.newsapp.data.api.response.Article
import com.iqbalfa.newsapp.data.repository.NewsRepository
import com.iqbalfa.newsapp.data.repository.NewsRepositoryImpl
import com.iqbalfa.newsapp.databinding.ActivityArticleBinding
import com.iqbalfa.newsapp.ui.article.viewadapter.ArticleAdapter
import com.iqbalfa.newsapp.ui.article.viewadapter.ArticleCellClickListener
import kotlinx.coroutines.launch

class ArticleActivity : AppCompatActivity(), ArticleCellClickListener {
    private lateinit var newsRepository: NewsRepository
    private lateinit var viewModel: ArticleViewModel
    private val adapter = ArticleAdapter(this)
    private lateinit var binding: ActivityArticleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            rvArticles.layoutManager = LinearLayoutManager(this@ArticleActivity)
            rvArticles.adapter = adapter
        }

        newsRepository = NewsRepositoryImpl()
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ArticleViewModel(newsRepository) as T
            }
        })[ArticleViewModel::class.java]
        subscribe()
    }

    private fun subscribe() {
        intent.getStringExtra("sourceId")?.let { source ->
            lifecycleScope.launch {
                viewModel.getArticleBySource(source).observe(this@ArticleActivity) {
                    it?.let {
                        adapter.submitData(lifecycle, it)
                        adapter.notifyDataSetChanged()
                    }
                }
            }
        }
    }

    override fun onCellClickListener(data: Article) {
        val uri = Uri.parse(data.url)
        val i = Intent(Intent.ACTION_VIEW, uri)
        startActivity(i)
    }
}