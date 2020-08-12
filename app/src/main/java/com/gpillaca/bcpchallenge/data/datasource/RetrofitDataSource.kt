package com.gpillaca.bcpchallenge.data.datasource

import com.gpillaca.bcpchallenge.data.server.CountriesDbServices
import com.gpillaca.bcpchallenge.data.toDomainCountries
import com.gpillaca.bcpchallenge.domain.Countries
import com.gpillaca.bcpchallenge.ui.common.OperationResult

class RetrofitDataSource(private val countriesDbServices: CountriesDbServices) : RemoteDataSource {
    override suspend fun listCountries(): OperationResult<Countries> {
        return try {
            val countries = countriesDbServices.listCountries().toDomainCountries()
            OperationResult.Success(countries)
        } catch (e: Exception) {
            OperationResult.Error(e)
        }
    }
}