package com.gpillaca.bcpchallenge.util

import com.google.gson.Gson

inline fun <reified T> String.toEntity(): T {
    return Gson().fromJson(this, T::class.java)
}