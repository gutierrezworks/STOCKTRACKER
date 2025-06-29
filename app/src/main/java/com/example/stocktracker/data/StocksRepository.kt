package com.example.stocktracker.data

import com.example.stocktracker.model.Stocks
import com.example.stocktracker.network.StockApiService

interface StocksRepository {
    suspend fun getStockData(symbol: String, timeframe: String, start: String): Stocks
}

class NetworkStocksRepository(
    private val retrofitService: StockApiService
): StocksRepository {
    override suspend fun getStockData(symbol: String, timeframe: String, start: String): Stocks {
        return retrofitService.getStockData(symbol = symbol, timeframe = timeframe, start = start)
    }
}