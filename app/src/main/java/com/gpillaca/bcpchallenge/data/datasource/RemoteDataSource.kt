package com.gpillaca.bcpchallenge.data.datasource

import com.gpillaca.bcpchallenge.domain.Countries
import com.gpillaca.bcpchallenge.ui.common.OperationResult

interface RemoteDataSource {
    suspend fun listCountries(): OperationResult<Countries>
}