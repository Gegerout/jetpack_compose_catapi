package com.example.catapiapplication.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.catapiapplication.ui.screens.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatsAppScreen(modifier: Modifier = Modifier) {
    val catViewModel: CatViewModel = viewModel(factory = CatViewModel.Factory)

    Scaffold(modifier = modifier.fillMaxSize()) {
        Surface(
            modifier = modifier
                .fillMaxSize()
                .padding(it)
        ) {
            HomeScreen(
                catUIState = catViewModel.catUIState,
                retryAction = { catViewModel.getBreeds() })
        }
    }
}