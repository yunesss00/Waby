package com.racoon.waby.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.racoon.waby.R
import com.racoon.waby.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}