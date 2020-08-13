package com.gpillaca.bcpchallenge.usecases

import com.gpillaca.bcpchallenge.data.repository.CountriesRepository
import com.gpillaca.bcpchallenge.domain.OperationDetail
import com.gpillaca.bcpchallenge.ui.common.OperationResult

class GetOperationDetail(private val countriesRepository: CountriesRepository) {
    suspend fun invoke(
        currencyCodeSendValue: String,
        currencyCodeGetValue: String
    ): OperationResult<OperationDetail> =
        countriesRepository.getOperationDetail(currencyCodeSendValue, currencyCodeGetValue)
}