package com.gpillaca.bcpchallenge

import com.gpillaca.bcpchallenge.data.repository.CountriesRepository
import com.gpillaca.bcpchallenge.ui.common.OperationResults
import com.gpillaca.bcpchallenge.ui.countries.CountriesContract
import com.gpillaca.bcpchallenge.ui.countries.CountriesPresenter
import com.gpillaca.bcpchallenge.usecases.GetCountriesOfOrigin
import com.gpillaca.bcpchallenge.usecases.GetCountriesOrigin
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CountriesPresenterTest {

    @Mock
    lateinit var countriesRepository: CountriesRepository

    @Mock
    lateinit var getCountriesOfOrigin: GetCountriesOfOrigin

    @Mock
    lateinit var getCountriesOrigin: GetCountriesOrigin

    @Mock
    lateinit var view: CountriesContract.View

    private lateinit var presenter: CountriesContract.Presenter

    @Before
    fun setUp() {
        presenter = CountriesPresenter(view, getCountriesOrigin, getCountriesOfOrigin)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `load Countries Origin`(){
        runBlocking {
            Dispatchers.setMain(Dispatchers.Unconfined)
            val countries = listOf(mockedCountry)

            whenever(getCountriesOrigin.invoke()).thenReturn(OperationResults.Success(countries))
            presenter.loadCountriesOrigin()

            verify(view).showProgress()
            verify(view).showCountries(countries)
            verify(view).hideProgress()
        }
    }
}