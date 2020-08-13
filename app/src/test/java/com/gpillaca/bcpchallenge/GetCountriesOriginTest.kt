package com.gpillaca.bcpchallenge

import com.gpillaca.bcpchallenge.data.repository.CountriesRepository
import com.gpillaca.bcpchallenge.domain.Country
import com.gpillaca.bcpchallenge.ui.common.OperationResults
import com.gpillaca.bcpchallenge.usecases.GetCountriesOrigin
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetCountriesOriginTest {

    @Mock
    lateinit var countriesRepository: CountriesRepository

    lateinit var getCountriesOrigin: GetCountriesOrigin

    @Before
    fun setUp() {
        getCountriesOrigin = GetCountriesOrigin(countriesRepository)
    }

    @Test
    fun `invoke calls movie repository`() {
        runBlocking {
            val countries = OperationResults.Success(listOf(mockedCountry))
            whenever(getCountriesOrigin.invoke()).thenReturn(countries)

            val result = getCountriesOrigin.invoke()
            assertEquals(countries, result)
        }
    }
}