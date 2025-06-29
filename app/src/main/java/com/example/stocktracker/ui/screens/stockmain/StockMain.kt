package com.example.stocktracker.ui.screens.stockmain

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.stocktracker.model.Stocks

@Composable
fun StockMain(
    stockUiState: StockUiState,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
    ) {
    when (stockUiState) {
        is StockUiState.Loading -> LoadingScreen()
        is StockUiState.Success -> ResultScreen(stockUiState.stocks)
        is StockUiState.Error -> ErrorScreen()
    }
}

@Composable
fun ResultScreen(
    stocks: Stocks,
    modifier: Modifier = Modifier
) {
    Text(
        text = stocks.bars.get("NVDA").toString()
    )
}

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier
) {
    Text(
        text = "Loading"
    )
}

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier
) {
    Text(
        text = "Error"
    )
}
