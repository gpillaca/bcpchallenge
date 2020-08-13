package com.gpillaca.bcpchallenge.di

import com.gpillaca.bcpchallenge.ui.main.CurrencyViewModel
import com.gpillaca.bcpchallenge.ui.main.MainActivity
import com.gpillaca.bcpchallenge.usecases.GetOperationDetail
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val scopesModule = module {
    scope(named<MainActivity>()) {
        viewModel { (currencyCodeSendValue: String, currencyCodeGetValue: String) ->
            CurrencyViewModel(
                getOperationDetail = get(),
                currencyCodeSendValue = currencyCodeSendValue,
                currencyCodeGetValue = currencyCodeGetValue
            )
        }
        scoped { GetOperationDetail(get()) }
    }
}