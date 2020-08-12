package com.gpillaca.bcpchallenge.ui.countries

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.gpillaca.bcpchallenge.databinding.ActivityCountriesBinding

class CountriesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCountriesBinding
    private lateinit var countriesAdapter: CountriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerViewCountries.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewCountries.addItemDecoration(
            CountryItemDecorator()
        )
        countriesAdapter = CountriesAdapter { }
    }
}