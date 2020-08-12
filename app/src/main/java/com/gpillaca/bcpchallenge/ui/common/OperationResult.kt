package com.gpillaca.bcpchallenge.ui.common

sealed class OperationResult<out T> {
    data class Success<T>(val data: T): OperationResult<T>()
    data class Error @JvmOverloads constructor(val exception: Exception, val message: String = "") : OperationResult<Nothing>()
}