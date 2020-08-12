package com.gpillaca.bcpchallenge.data.server

import com.gpillaca.bcpchallenge.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val countriesDbServices: CountriesDbServices by lazy { retrofit().create(CountriesDbServices::class.java) }
}