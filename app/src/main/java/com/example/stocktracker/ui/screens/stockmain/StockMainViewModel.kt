package com.example.stocktracker.ui.screens.stockmain

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.stocktracker.StockTrackerApplication
import com.example.stocktracker.data.NetworkStocksRepository
import com.example.stocktracker.data.StocksRepository
import com.example.stocktracker.model.Stocks
import kotlinx.coroutines.launch


//Create a mutable state StockUiState that will be observed by the UI and
// change on call requests
sealed interface StockUiState {
    data class Success(val stocks: Stocks) : StockUiState
    object Error : StockUiState
    object Loading : StockUiState
}

class StockMainViewModel(
    private val stocksRepository: StocksRepository
): ViewModel() {

    // To make it state:
    // var stockUiState: StockUiState = StockUiState.Loading
    var stockUiState: StockUiState by mutableStateOf(StockUiState.Loading)

    init {
        getStockData("NVDA", "1D", "2025-06-25")
    }

    fun getStockData(symbol: String, timeframe: String, start: String) {
        viewModelScope.launch {
            stockUiState = try {
                val listResult = stocksRepository.getStockData(symbol = symbol, timeframe = timeframe, start = start)
                Log.d("listResult", listResult.toString())
                StockUiState.Success(listResult)
            } catch (e: Exception) {
                Log.e("listResult", e.stackTraceToString())
                StockUiState.Error
            }
        }
    }
}