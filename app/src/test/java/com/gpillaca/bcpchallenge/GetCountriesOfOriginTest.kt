package com.gpillaca.bcpchallenge

import com.gpillaca.bcpchallenge.data.repository.CountriesRepository
import com.gpillaca.bcpchallenge.ui.common.OperationResults
import com.gpillaca.bcpchallenge.usecases.GetCountriesOfOrigin
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetCountriesOfOriginTest {

    @Mock
    lateinit var countriesRepository: CountriesRepository

    lateinit var getCountriesOfOrigin: GetCountriesOfOrigin

    @Before
    fun setUp() {
        getCountriesOfOrigin = GetCountriesOfOrigin(countriesRepository)
    }

    @Test
    fun `invoke calls movie repository`() {
        runBlocking {
            val countries = OperationResults.Success(listOf(mockedCountry))
            whenever(getCountriesOfOrigin.invoke("USD")).thenReturn(countries)

            val result = getCountriesOfOrigin.invoke("USD")
            assertEquals(countries, result)
        }
    }
}