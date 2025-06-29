package com.example.stocktracker

import android.app.Application
import com.example.stocktracker.data.AppContainer
import com.example.stocktracker.data.DefaultAppContainer

class StockTrackerApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}