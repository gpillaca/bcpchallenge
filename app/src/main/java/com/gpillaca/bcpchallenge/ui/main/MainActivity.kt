package com.gpillaca.bcpchallenge.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gpillaca.bcpchallenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.cardViewChangeCurrency
        setContentView(binding.root)
    }
}