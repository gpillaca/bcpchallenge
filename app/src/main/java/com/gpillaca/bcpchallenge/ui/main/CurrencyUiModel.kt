package com.gpillaca.bcpchallenge.ui.main

import com.gpillaca.bcpchallenge.domain.OperationDetail

sealed class CurrencyUiModel {
    object Loading : CurrencyUiModel()
    data class ContentOperationResult(val operationDetail: OperationDetail) : CurrencyUiModel()
    data class CurrencyConvert(val youGetMoney: Double) : CurrencyUiModel()
}