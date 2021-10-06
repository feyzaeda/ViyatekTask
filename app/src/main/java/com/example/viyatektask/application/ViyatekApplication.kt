package com.example.viyatektask.application

import android.app.Application

class ViyatekApplication : Application() {

    companion object {
        @Volatile
        private lateinit var INSTANCE: ViyatekApplication

        fun getInstance(): ViyatekApplication = INSTANCE
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}