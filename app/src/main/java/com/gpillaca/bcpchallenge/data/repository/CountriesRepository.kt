package com.gpillaca.bcpchallenge.data.repository

import com.gpillaca.bcpchallenge.domain.Countries
import com.gpillaca.bcpchallenge.ui.common.OperationResult

interface CountriesRepository {
    suspend fun listCountries(): OperationResult<Countries>
}