package com.gpillaca.bcpchallenge.data.repository

import com.gpillaca.bcpchallenge.data.datasource.RemoteDataSource
import com.gpillaca.bcpchallenge.domain.Country
import com.gpillaca.bcpchallenge.ui.common.OperationResults

private const val DEFAULT_VALUE = 0.0

class CountriesRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : CountriesRepository {

    override suspend fun listCountriesOrigin(): OperationResults<Country> {
        val originCountries = mutableListOf<Country>()

        when (val response = remoteDataSource.listCountries()) {
            is OperationResults.Success -> {
                response.data.map {
                    originCountries.add(
                        Country(it.name, it.flag, it.currency, DEFAULT_VALUE, DEFAULT_VALUE)
                    )
                }
            }
        }

        return OperationResults.Success(originCountries)
    }

    override suspend fun listCountriesOfOrigin(currencyCode: String): OperationResults<Country> {
        val countriesOfOrigin = mutableListOf<Country>()

        when (val response = remoteDataSource.listCountries()) {
            is OperationResults.Success -> {
                response.data.forEach { country ->
                    if (country.currency.code == currencyCode) {
                        countriesOfOrigin.addAll(country.countriesConverter)
                    }
                }
            }
        }

        return OperationResults.Success(countriesOfOrigin)
    }
}