package com.gpillaca.bcpchallenge.di

import android.app.Application
import com.gpillaca.bcpchallenge.data.database.AppDatabase
import com.gpillaca.bcpchallenge.data.datasource.*
import com.gpillaca.bcpchallenge.data.server.ApiClient
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun Application.initDI() {
    startKoin {
        androidContext(this@initDI)
        modules(listOf(appModule, dataModule, scopesModule, presenterModule))
    }
}

val appModule = module {
    single { AppDatabase.getInstance(get()) }
    single { ApiClient.countriesDbServices }
    factory<LocalDataSource> { RoomDataSource(get()) }
    factory<RemoteDataSource>() { RetrofitDataSource(countriesDbServices = get()) }
    //factory<RemoteDataSource>(named("fakeRetrofit")) { FakeRetrofitDataSource(context = get()) }
}