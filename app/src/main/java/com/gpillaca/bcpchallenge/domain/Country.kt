package com.gpillaca.bcpchallenge.domain

data class Countries(
    val name: String,
    val flag: String,
    val currency: Currency,
    val countriesConverter: List<Country>
)

data class Country(
    val name: String,
    val flag: String,
    val currency: Currency,
    val purchaseValue: Double,
    val saleValue: Double
)