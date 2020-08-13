package com.gpillaca.bcpchallenge.data.database.dao

import androidx.room.*
import com.gpillaca.bcpchallenge.data.database.entity.UserCurrency

@Dao
interface UserCurrencyDao {
    @Query("SELECT * FROM UserCurrency")
    fun getCurrencyValues(): UserCurrency

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertCurrencyValues(userCurrency: UserCurrency)

    @Update
    fun updateCurrencyValues(currency: UserCurrency)
}