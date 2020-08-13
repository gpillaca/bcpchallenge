package com.gpillaca.bcpchallenge.ui.countries

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.gpillaca.bcpchallenge.databinding.ActivityCountriesBinding
import com.gpillaca.bcpchallenge.domain.Country
import kotlinx.android.synthetic.main.activity_countries.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class CountriesActivity : AppCompatActivity(), CountriesContract.View {

    private lateinit var binding: ActivityCountriesBinding
    private lateinit var countriesAdapter: CountriesAdapter

    private val presenter: CountriesContract.Presenter by inject { parametersOf(this) }

    private var currencyCode: String? = null

    companion object {
        const val PARAM_CURRENCY = "CountriesActivity:currency"
        const val PARAM_COUNTRY = "CountriesActivity:country"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        currencyCode = intent.getStringExtra(PARAM_CURRENCY)

        binding.recyclerViewCountries.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewCountries.addItemDecoration(
            CountryItemDecorator()
        )

        currencyCode?.let {
            presenter.loadCountriesOfOrigin(it)
        } ?: run { presenter.loadCountriesOrigin() }

        countriesAdapter = CountriesAdapter { country ->
            Toast.makeText(this, country.name, Toast.LENGTH_SHORT).show()
            val intent = Intent().apply { putExtra(PARAM_COUNTRY, country) }
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        recyclerViewCountries.adapter = countriesAdapter
    }

    override fun showCountriesWithOrigin(countries: List<Country>, currencyCode: String) {
        countriesAdapter.countries = countries
        countriesAdapter.currencyCode = currencyCode
    }

    override fun showCountries(countries: List<Country>) {
        countriesAdapter.countries = countries
        countriesAdapter.currencyCode = ""
    }
}