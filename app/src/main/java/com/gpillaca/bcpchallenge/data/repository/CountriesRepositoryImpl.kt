package com.gpillaca.bcpchallenge.data.repository

import com.gpillaca.bcpchallenge.data.datasource.RemoteDataSource
import com.gpillaca.bcpchallenge.domain.Countries
import com.gpillaca.bcpchallenge.ui.common.OperationResult

class CountriesRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : CountriesRepository {
    override suspend fun listCountries(): OperationResult<Countries> {
        return remoteDataSource.listCountries()
    }
}