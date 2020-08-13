package com.gpillaca.bcpchallenge.data.datasource

import com.gpillaca.bcpchallenge.data.server.CountriesDbServices
import com.gpillaca.bcpchallenge.data.toDomainCountries
import com.gpillaca.bcpchallenge.domain.Countries
import com.gpillaca.bcpchallenge.ui.common.OperationResults

class RetrofitDataSource(private val countriesDbServices: CountriesDbServices) : RemoteDataSource {
    override suspend fun listCountries(): OperationResults<Countries> {
        return try {
            val countries: List<Countries> = countriesDbServices.listCountries().map {
                it.toDomainCountries()
            }
            OperationResults.Success(countries)
        } catch (e: Exception) {
            OperationResults.Error(e)
        }
    }
}