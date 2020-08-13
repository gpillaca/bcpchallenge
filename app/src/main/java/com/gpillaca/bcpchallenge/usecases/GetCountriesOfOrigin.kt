package com.gpillaca.bcpchallenge.usecases

import com.gpillaca.bcpchallenge.data.repository.CountriesRepository
import com.gpillaca.bcpchallenge.domain.Country
import com.gpillaca.bcpchallenge.ui.common.OperationResults

class GetCountriesOfOrigin(private val countriesRepository: CountriesRepository) {
    suspend fun invoke(currencyCode: String) : OperationResults<Country> = countriesRepository.listCountriesOfOrigin(currencyCode)
}