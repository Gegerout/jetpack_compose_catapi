package com.example.catapiapplication.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.catapiapplication.R
import com.example.catapiapplication.data.Breeds

@Composable
fun BreedCard(breed: Breeds, modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxSize(), elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(modifier = Modifier.padding(5.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current).data(breed.image)
                    .crossfade(true).build(),
                contentDescription = "catImages",
                modifier = Modifier.size(100.dp),
                error = painterResource(id = R.drawable.ic_connection_error),
                placeholder = painterResource(id = R.drawable.loading_img)
            )
            Spacer(modifier = Modifier.width(50.dp))
            Column {
                breed.name?.let {
                    Text(
                        text = it,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = modifier.width(100.dp)
                    )
                }
                breed.description?.let {
                    Text(
                        text = it,
                        fontSize = 15.sp
                    )
                }
            }
        }
    }
}

@Composable
fun BreedsListScreen(
    breeds: List<Breeds>
) {
    LazyColumn(contentPadding = PaddingValues(4.dp)) {
        items(breeds) { breed -> BreedCard(breed) }
    }
}