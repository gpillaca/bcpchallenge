package com.gpillaca.bcpchallenge.data.datasource

import com.gpillaca.bcpchallenge.domain.UserCurrency

interface LocalDataSource {
    suspend fun getUserCurrencyValues(): UserCurrency
    suspend fun saveCurrencyValues(userCurrency: UserCurrency)
    suspend fun updateCurrencyValues(userCurrency: UserCurrency)
}