package com.gpillaca.bcpchallenge.data.datasource

import com.gpillaca.bcpchallenge.data.database.AppDatabase
import com.gpillaca.bcpchallenge.data.toDataBaseUserCurrency
import com.gpillaca.bcpchallenge.data.toDomainUserCurrency
import com.gpillaca.bcpchallenge.domain.UserCurrency
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomDataSource(private val appDatabase: AppDatabase) : LocalDataSource {

    override suspend fun getUserCurrencyValues(): UserCurrency = withContext(Dispatchers.IO) {
        appDatabase.userCurrencyDao().getCurrencyValues().toDomainUserCurrency()
    }

    override suspend fun saveCurrencyValues(userCurrency: UserCurrency) =
        withContext(Dispatchers.IO) {
            appDatabase.userCurrencyDao()
                .insertCurrencyValues(userCurrency.toDataBaseUserCurrency())
        }

    override suspend fun updateCurrencyValues(userCurrency: UserCurrency) =
        withContext(Dispatchers.IO) {
            appDatabase.userCurrencyDao()
                .updateCurrencyValues(userCurrency.toDataBaseUserCurrency())
        }
}