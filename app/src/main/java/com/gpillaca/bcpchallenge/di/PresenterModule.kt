package com.gpillaca.bcpchallenge.di

import com.gpillaca.bcpchallenge.ui.countries.CountriesContract
import com.gpillaca.bcpchallenge.ui.countries.CountriesPresenter
import com.gpillaca.bcpchallenge.usecases.GetCountriesOfOrigin
import com.gpillaca.bcpchallenge.usecases.GetCountriesOrigin
import org.koin.dsl.module

val presenterModule = module {
    factory<CountriesContract.Presenter> { (view: CountriesContract.View) ->
        CountriesPresenter(
            view = view,
            getCountriesOrigin = GetCountriesOrigin(get()),
            getCountriesOfOrigin = GetCountriesOfOrigin(get())
        )
    }
}