package com.gpillaca.bcpchallenge.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gpillaca.bcpchallenge.ui.common.Scope
import com.gpillaca.bcpchallenge.usecases.GetCountriesOrigin
import kotlinx.coroutines.launch

class CurrencyViewModel(
    private val getCountriesOrigin: GetCountriesOrigin
): ViewModel(), Scope by Scope.Impl() {

    init {
        createScope()
    }

    private val _model = MutableLiveData<CurrencyUiModel>()
    val model: LiveData<CurrencyUiModel>
    get() {
        if (_model.value == null) {
            loadContentCurrency()
        }
        return _model
    }

    private fun loadContentCurrency() {
        launch {
            _model.value = CurrencyUiModel.Loading
        }
    }

    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }
}