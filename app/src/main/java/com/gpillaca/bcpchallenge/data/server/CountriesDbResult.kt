package com.gpillaca.bcpchallenge.data.server

import com.google.gson.annotations.SerializedName

data class CountriesDbResult(
    val name: String,
    val flag: String,
    val currency: Currency,
    @SerializedName("countries_converter") val countriesConverter: List<Country>
)