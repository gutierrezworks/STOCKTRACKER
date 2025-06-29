package com.example.stocktracker.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Stocks(
    @SerialName("bars") val bars: Map<String, List<Bar>>,
    @SerialName("next_page_token") val nextPageToken: String? = null
)

@Serializable
data class Bar(
    @SerialName("o") val opening: Double = 0.0,
    @SerialName("c") val close: Double = 0.0,
    @SerialName("t") val time: String = "0-0-0000",
    @SerialName("v") val volume: Long = 0,
    @SerialName("h") val high: Double = 0.0,
    @SerialName("l") val low: Double = 0.0,
    @SerialName("n") val transactions: Long = 0,
    @SerialName("vw") val volumeWeightedPrice: Double = 0.0
)