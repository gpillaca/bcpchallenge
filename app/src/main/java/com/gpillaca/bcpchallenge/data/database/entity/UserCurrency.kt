package com.gpillaca.bcpchallenge.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserCurrency(
    @PrimaryKey(autoGenerate = false)
    val currencyCodeSendValue: String,
    @ColumnInfo
    val currencyCodeGetValue: String
)