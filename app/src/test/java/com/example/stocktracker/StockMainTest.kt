package com.example.stocktracker

import com.example.stocktracker.data.NetworkStocksRepository
import com.example.stocktracker.data.StocksRepository
import com.example.stocktracker.model.Bar
import com.example.stocktracker.model.Stocks
import com.example.stocktracker.network.StockApiService
import org.junit.Test

class StockMainTest {
}

class FakeStockService: StockApiService {
    override suspend fun getStockData(
        apiKey: String,
        apiKeySecret: String,
        symbol: String,
        timeframe: String,
        start: String,
        sort: String
    ): Stocks {
        return fakeData
    }
}

private val fakeData = Stocks(
    bars = mutableMapOf("APPL" to listOf(Bar()))
)