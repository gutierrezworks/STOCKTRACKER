package com.example.stocktracker.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.stocktracker.StockTrackerApplication
import com.example.stocktracker.ui.screens.stockmain.StockMainViewModel

class ViewModelFactory {
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as StockTrackerApplication)
                val stocksRepository = application.container.stocksRepository
                StockMainViewModel(stocksRepository = stocksRepository)
            }
        }
    }
}
