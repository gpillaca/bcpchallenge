package com.gpillaca.bcpchallenge.ui.main

sealed class CurrencyUiModel {
    object Loading : CurrencyUiModel()
    data class ContentCurrency(
        val youSendCurrencyDescription: String,
        val youGetMoneyCurrencyDescription: String,
        val purchaseValue: Double,
        val saleValue: Double) : CurrencyUiModel()
    data class CurrencyConvert(val youGetMoney: Double) : CurrencyUiModel()
}