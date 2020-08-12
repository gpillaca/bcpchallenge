package com.gpillaca.bcpchallenge.usecases

import com.gpillaca.bcpchallenge.data.repository.CountriesRepository
import com.gpillaca.bcpchallenge.domain.Countries
import com.gpillaca.bcpchallenge.ui.common.OperationResult

class GetCountries(private val countriesRepository: CountriesRepository) {
    suspend fun invoke() : OperationResult<Countries> = countriesRepository.listCountries()
}