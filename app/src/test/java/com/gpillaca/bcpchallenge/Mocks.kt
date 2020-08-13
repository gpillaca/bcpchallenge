package com.gpillaca.bcpchallenge

import com.gpillaca.bcpchallenge.domain.Country
import com.gpillaca.bcpchallenge.domain.Currency

val mockedCurrency = Currency(
    "PEN",
    "Soles"
)

val mockedCountry = Country(
    "Perú",
    "https://upload.wikimedia.org/wikipedia/commons/f/f2/Bandera_peruana_DOS.jpg",
    mockedCurrency,
    0.0,
    0.0
)