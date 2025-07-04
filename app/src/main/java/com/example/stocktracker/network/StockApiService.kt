package com.example.stocktracker.network

import com.example.stocktracker.model.Stocks
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

private val API_KEY = ""
private val API_KEY_SECRET = ""

interface StockApiService {

     @GET("stocks/bars")
     suspend fun getStockData(
         @Header("APCA-API-KEY-ID") apiKey: String = API_KEY,
         @Header("APCA-API-SECRET-KEY") apiKeySecret: String = API_KEY_SECRET,
         @Query("symbols") symbol: String,
         @Query("timeframe") timeframe: String,
         @Query("start") start: String,
         @Query("sort") sort: String = "desc",
         ): Stocks
}

