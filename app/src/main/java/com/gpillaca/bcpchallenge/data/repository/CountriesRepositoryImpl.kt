package com.gpillaca.bcpchallenge.data.repository

import com.gpillaca.bcpchallenge.data.datasource.RemoteDataSource
import com.gpillaca.bcpchallenge.domain.Country
import com.gpillaca.bcpchallenge.domain.OperationDetail
import com.gpillaca.bcpchallenge.ui.common.OperationResult
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

    override suspend fun getOperationDetail(
        currencyCodeSendValue: String,
        currencyCodeGetValue: String
    ): OperationResult<OperationDetail> {
        var countryOfOrigin: Country? = null
        lateinit var countryOrigin: Country

        when (val response = remoteDataSource.listCountries()) {
            is OperationResults.Success -> response.data.forEach { country ->
                if (country.currency.code == currencyCodeSendValue) {
                    countryOrigin = Country(
                        country.name,
                        country.flag,
                        country.currency,
                        DEFAULT_VALUE,
                        DEFAULT_VALUE
                    )

                    countryOfOrigin =
                        getCountry(country.countriesConverter, currencyCodeGetValue)
                    return@forEach
                }
            }
        }

        if (countryOfOrigin == null) {
            return OperationResult.Error(Exception("Ocurrio un error al obtener el país"))
        }

        val operationDetail = OperationDetail(
            countryOrigin.currency.code,
            countryOrigin.currency.description,
            countryOfOrigin!!.currency.code,
            countryOfOrigin!!.currency.description,
            countryOfOrigin!!.purchaseValue,
            countryOfOrigin!!.saleValue
        )

        return OperationResult.Success(operationDetail)
    }

    private fun getCountry(countries: List<Country>, currencyCodeGetValue: String): Country? {
        countries.forEach {
            if (it.currency.code == currencyCodeGetValue) {
                return it
            }
        }

        return null
    }
}