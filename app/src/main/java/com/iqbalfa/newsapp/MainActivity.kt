package com.iqbalfa.newsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.iqbalfa.newsapp.databinding.ActivityMainBinding
import com.iqbalfa.newsapp.ui.newssource.NewsSourceActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val i = Intent(this, NewsSourceActivity::class.java)
        binding.apply {
            btnBusiness.setOnClickListener {
                i.putExtra("category", "business")
                startActivity(i)
            }
            btnEntertainment.setOnClickListener {
                i.putExtra("category", "entertainment")
                startActivity(i)
            }
            btnGeneral.setOnClickListener {
                i.putExtra("category", "general")
                startActivity(i)
            }
        }
    }
}