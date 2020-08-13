package com.gpillaca.bcpchallenge.data.repository

import com.gpillaca.bcpchallenge.domain.Country
import com.gpillaca.bcpchallenge.domain.OperationDetail
import com.gpillaca.bcpchallenge.ui.common.OperationResult
import com.gpillaca.bcpchallenge.ui.common.OperationResults

interface CountriesRepository {
    suspend fun listCountriesOrigin(): OperationResults<Country>
    suspend fun listCountriesOfOrigin(currencyCode: String): OperationResults<Country>
    suspend fun getOperationDetail(currencyCodeSendValue: String, currencyCodeGetValue: String): OperationResult<OperationDetail>
}