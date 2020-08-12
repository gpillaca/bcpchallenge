package com.gpillaca.bcpchallenge.di

import com.gpillaca.bcpchallenge.data.repository.CountriesRepository
import com.gpillaca.bcpchallenge.data.repository.CountriesRepositoryImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    factory<CountriesRepository> {
        CountriesRepositoryImpl(
            remoteDataSource = get(named("fakeRetrofit"))
        )
    }
}