package com.gpillaca.bcpchallenge.data.datasource

import com.gpillaca.bcpchallenge.domain.Countries
import com.gpillaca.bcpchallenge.ui.common.OperationResults

interface RemoteDataSource {
    suspend fun listCountries(): OperationResults<Countries>
}