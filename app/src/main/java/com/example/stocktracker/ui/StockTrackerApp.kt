package com.example.stocktracker.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.stocktracker.ui.screens.stockmain.StockMain
import com.example.stocktracker.ui.screens.stockmain.StockMainViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StockTrackerApp() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { StockTopAppBar(scrollBehavior = scrollBehavior) }
    ) {
        Surface(
            modifier = Modifier.fillMaxSize().padding(it)
        ) {
            val viewModel: StockMainViewModel = viewModel(factory = ViewModelFactory.Factory)
            StockMain(
                stockUiState = viewModel.stockUiState,
                contentPadding = it,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StockTopAppBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = "STOCK TRACKER APP",
                style = MaterialTheme.typography.headlineSmall,
            )
        },
        modifier = modifier
    )
}