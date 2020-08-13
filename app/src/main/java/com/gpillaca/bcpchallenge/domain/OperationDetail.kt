package com.gpillaca.bcpchallenge.domain

data class OperationDetail(
    val currencyCodeSendValue: String,
    val currencyDescriptionSendValue: String,
    val currencyCodeGetValue: String,
    val currencyDescriptionGetValue: String,
    val purchaseValue: Double,
    val saleValue: Double
) {
    var youGetValue: Double = 0.0
}