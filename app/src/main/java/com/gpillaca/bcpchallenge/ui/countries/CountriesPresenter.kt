package com.gpillaca.bcpchallenge.ui.countries

import com.gpillaca.bcpchallenge.ui.common.OperationResults
import com.gpillaca.bcpchallenge.ui.common.Scope
import com.gpillaca.bcpchallenge.usecases.GetCountriesOfOrigin
import com.gpillaca.bcpchallenge.usecases.GetCountriesOrigin
import kotlinx.coroutines.launch

class CountriesPresenter(
    private val view: CountriesContract.View,
    private val getCountriesOrigin: GetCountriesOrigin,
    private val getCountriesOfOrigin: GetCountriesOfOrigin
) : CountriesContract.Presenter, Scope by Scope.Impl() {

    init {
        createScope()
    }

    override fun loadCountriesOfOrigin(currencyCode: String) {
        launch {
            view.showProgress()
            when (val result = getCountriesOfOrigin.invoke(currencyCode)) {
                is OperationResults.Success -> {
                    view.showCountriesWithOrigin(result.data, currencyCode)
                }
            }
            view.hideProgress()
        }
    }

    override fun loadCountriesOrigin() {
        launch {
            view.showProgress()
            when (val result = getCountriesOrigin.invoke()) {
                is OperationResults.Success -> {
                    view.showCountries(result.data)
                }
            }
            view.hideProgress()
        }
    }

    override fun onDestroyScope() {
        destroyScope()
    }
}