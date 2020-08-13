package com.gpillaca.bcpchallenge.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gpillaca.bcpchallenge.ui.common.OperationResult
import com.gpillaca.bcpchallenge.ui.common.Scope
import com.gpillaca.bcpchallenge.usecases.GetCountriesOrigin
import com.gpillaca.bcpchallenge.usecases.GetOperationDetail
import kotlinx.coroutines.launch

class CurrencyViewModel(
    private val getOperationDetail: GetOperationDetail,
    private val currencyCodeSendValue: String,
    private val currencyCodeGetValue: String
) : ViewModel(), Scope by Scope.Impl() {

    init {
        createScope()
    }

    private val _model = MutableLiveData<CurrencyUiModel>()
    val model: LiveData<CurrencyUiModel>
        get() {
            if (_model.value == null) {
                loadContentCurrency(currencyCodeSendValue, currencyCodeGetValue)
            }
            return _model
        }

    private fun loadContentCurrency(
        currencyCodeSendValue: String,
        currencyCodeGetValue: String
    ) {
        launch {
            _model.value = CurrencyUiModel.Loading

            when (val response =
                getOperationDetail.invoke(currencyCodeSendValue, currencyCodeGetValue)) {
                is OperationResult.Success -> {
                    _model.value = CurrencyUiModel.ContentOperationResult(response.data)
                }
            }
        }
    }

    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }
}