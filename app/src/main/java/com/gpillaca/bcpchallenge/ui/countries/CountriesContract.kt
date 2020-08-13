package com.gpillaca.bcpchallenge.ui.countries

import com.gpillaca.bcpchallenge.domain.Country

interface CountriesContract {
    interface View {
        fun showCountries(countries: List<Country>)
        fun showCountriesWithOrigin(countries: List<Country>, currencyCode: String)
    }

    interface Presenter {
        fun loadCountriesOfOrigin(currencyCode: String)
        fun loadCountriesOrigin()
    }
}