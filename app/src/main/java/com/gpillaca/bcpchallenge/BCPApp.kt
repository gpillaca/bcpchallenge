package com.gpillaca.bcpchallenge

import android.app.Application
import com.gpillaca.bcpchallenge.di.initDI

class BCPApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initDI()
    }
}