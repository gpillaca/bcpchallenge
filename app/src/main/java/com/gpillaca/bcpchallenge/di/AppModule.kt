package com.gpillaca.bcpchallenge.di

import android.app.Application
import com.gpillaca.bcpchallenge.data.datasource.FakeRetrofitDataSource
import com.gpillaca.bcpchallenge.data.datasource.RemoteDataSource
import com.gpillaca.bcpchallenge.data.datasource.RetrofitDataSource
import com.gpillaca.bcpchallenge.data.server.ApiClient
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun Application.initDI() {
    startKoin {
        androidContext(this@initDI)
        modules(listOf(appModule, dataModule, scopesModule))
    }
}

val appModule = module {
    single { ApiClient.countriesDbServices }
    factory<RemoteDataSource>(named("retrofit")) { RetrofitDataSource(countriesDbServices = get()) }
    factory<RemoteDataSource>(named("fakeRetrofit")) { FakeRetrofitDataSource(countriesDbServices = get()) }
}