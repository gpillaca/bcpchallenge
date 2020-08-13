package com.gpillaca.bcpchallenge.data

import com.gpillaca.bcpchallenge.data.database.entity.UserCurrency as DataBaseUserCurrency
import com.gpillaca.bcpchallenge.data.server.CountriesDbResult
import com.gpillaca.bcpchallenge.domain.Countries
import com.gpillaca.bcpchallenge.domain.Country
import com.gpillaca.bcpchallenge.domain.Currency
import com.gpillaca.bcpchallenge.domain.UserCurrency as DomainUserCurrency

fun CountriesDbResult.toDomainCountries(): Countries {

    val currency = Currency(this.currency.code, this.currency.description)
    val countriesConverter = mutableListOf<Country>()

    this.countriesConverter.forEach { country ->
        countriesConverter.add(
            Country(
                country.name,
                country.flag,
                Currency(country.currency.code, country.currency.description),
                country.purchaseValue,
                country.saleValue
            )
        )
    }

    return Countries(
        name,
        flag,
        currency,
        countriesConverter
    )
}

fun DataBaseUserCurrency.toDomainUserCurrency() =
    DomainUserCurrency(currencyCodeSendValue, currencyCodeGetValue)

fun DomainUserCurrency.toDataBaseUserCurrency() =
    DataBaseUserCurrency(currencyCodeSendValue, currencyCodeGetValue)