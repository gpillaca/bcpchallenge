package com.gpillaca.bcpchallenge

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.gpillaca.bcpchallenge.ui.common.OperationResult
import com.gpillaca.bcpchallenge.ui.main.CurrencyUiModel
import com.gpillaca.bcpchallenge.ui.main.CurrencyViewModel
import com.gpillaca.bcpchallenge.usecases.GetOperationDetail
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

private const val DEFAULT_CODE_YOU_SEND_MONEY = "PEN"
private const val DEFAULT_CODE_YOU_GET_MONEY = "USD"

@RunWith(MockitoJUnitRunner::class)
class CurrencyViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var getOperationDetail: GetOperationDetail

    @Mock
    lateinit var observer: Observer<CurrencyUiModel>

    private lateinit var currencyViewModel: CurrencyViewModel

    @Before
    fun setUp() {
        currencyViewModel = CurrencyViewModel(
            getOperationDetail,
            DEFAULT_CODE_YOU_SEND_MONEY,
            DEFAULT_CODE_YOU_GET_MONEY
        )
    }

    @Test
    fun `load operation detail`() = runBlocking {
        Dispatchers.setMain(Dispatchers.Unconfined)
        val operationDetail = mockedOperationDetail

        whenever(
            getOperationDetail.invoke(
                DEFAULT_CODE_YOU_SEND_MONEY,
                DEFAULT_CODE_YOU_GET_MONEY
            )
        ).thenReturn(OperationResult.Success(operationDetail))

        currencyViewModel.model.observeForever(observer)

        verify(observer).onChanged(CurrencyUiModel.ContentOperationResult(operationDetail))
    }
}