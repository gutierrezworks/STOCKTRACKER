package com.example.stocktracker.data

import com.example.stocktracker.network.StockApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

interface AppContainer {
    val stocksRepository: StocksRepository
}

class DefaultAppContainer(): AppContainer {

    private val baseUrl = "https://data.alpaca.markets/v2/"

    private val _client =
        OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor()
                .apply { level = HttpLoggingInterceptor.Level.BODY })
            .build()

    private val json = Json {
        ignoreUnknownKeys = true // Allows parsing even if there are unknown keys in the JSON response
        isLenient = true         // Makes the parser more lenient
    }

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .client(_client)
        .baseUrl(baseUrl)
        .build()

    private val retrofitService: StockApiService by lazy {
        retrofit.create(StockApiService::class.java)
    }

    override val stocksRepository: StocksRepository by lazy {
        NetworkStocksRepository(retrofitService)
    }
}