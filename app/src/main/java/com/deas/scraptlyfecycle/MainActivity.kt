package com.deas.scraptlyfecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var scrapingData: ScrapingData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupScrapingData()
    }

    private fun setupScrapingData() {
        scrapingData = ScrapingData(lifecycle) { message ->
            Log.d(MainActivity::class.java.name, message)
        }
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.userLogin().observe(this) { login ->
            if (login) {
                scrapingData.enabled()
            }
        }
    }

}