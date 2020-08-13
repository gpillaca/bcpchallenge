package com.gpillaca.bcpchallenge

import com.gpillaca.bcpchallenge.domain.Country
import com.gpillaca.bcpchallenge.domain.Currency
import com.gpillaca.bcpchallenge.domain.OperationDetail

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

val mockedOperationDetail = OperationDetail(
    "PEN",
    "Soles",
    "USD",
    "Dólares",
    3.56,
    3.563
)