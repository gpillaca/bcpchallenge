package com.gpillaca.bcpchallenge.domain

import com.google.gson.annotations.SerializedName

data class Countries(
    val name: String,
    val flag: String,
    val currency: Currency,
    @SerializedName("countries_converter") val countriesConverter: List<Country>
)

data class Country(
    val name: String,
    val flag: String,
    val currency: Currency,
    @SerializedName("purchase_value") val purchaseValue: Double,
    @SerializedName("sale_value") val saleValue: Double
)