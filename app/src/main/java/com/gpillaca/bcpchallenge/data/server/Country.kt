package com.gpillaca.bcpchallenge.data.server

import com.google.gson.annotations.SerializedName

data class Country(
    val name: String,
    val flag: String,
    val currency: Currency,
    @SerializedName("purchase_value") val purchaseValue: Double,
    @SerializedName("sale_value") val saleValue: Double
)