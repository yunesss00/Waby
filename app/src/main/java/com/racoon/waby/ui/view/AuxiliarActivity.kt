package com.racoon.waby.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.racoon.waby.databinding.ActivityAuxiliarBinding

class AuxiliarActivity : AppCompatActivity() {
    lateinit var binding: ActivityAuxiliarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuxiliarBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}