package com.gpillaca.bcpchallenge.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gpillaca.bcpchallenge.data.database.dao.UserCurrencyDao
import com.gpillaca.bcpchallenge.data.database.entity.UserCurrency

private const val DATA_BASE = "BCPDatabase.db"

@Database(entities = [UserCurrency::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userCurrencyDao(): UserCurrencyDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(AppDatabase::class) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATA_BASE
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}