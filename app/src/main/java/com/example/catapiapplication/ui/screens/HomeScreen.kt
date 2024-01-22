package com.example.catapiapplication.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.catapiapplication.ui.CatUIState

@Composable
fun HomeScreen(
    catUIState: CatUIState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    when(catUIState) {
        is CatUIState.Loading -> LoadingScreen(modifier)
        is CatUIState.Success -> BreedsListScreen(breeds = catUIState.breeds)
        is CatUIState.Error -> ErrorScreen(retry = retryAction, modifier)
    }
}