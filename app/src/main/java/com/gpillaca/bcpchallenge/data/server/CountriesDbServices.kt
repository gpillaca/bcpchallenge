package com.gpillaca.bcpchallenge.data.server

import retrofit2.http.GET

interface CountriesDbServices {
    @GET("countries")
    suspend fun listCountries(): List<CountriesDbResult>
}