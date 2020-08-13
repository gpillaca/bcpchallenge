package com.gpillaca.bcpchallenge.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class Countries(
    val name: String,
    val flag: String,
    val currency: Currency,
    val countriesConverter: List<Country>
)

@Parcelize
data class Country(
    val name: String,
    val flag: String,
    val currency: Currency,
    val purchaseValue: Double,
    val saleValue: Double
) : Parcelable