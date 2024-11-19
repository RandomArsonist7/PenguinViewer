package com.example.app1jetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MainUI(
    items: List<CardItem>,
    onCardClick: (Int) -> Unit
) {

    val allLikesZero = items.all {it.likes == 0}

    val mostLikedPenguin = if (!allLikesZero) {
        items.maxByOrNull {it.likes}
    } else {
        null
    }

    Column(
        modifier = Modifier
            .fillMaxSize()) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f / 12f),
            contentAlignment = Alignment.Center
        ) {
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(all = 10.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Anastazja Sofińska",
                        style = MaterialTheme.typography.headlineLarge
                    )

                    Spacer(modifier = Modifier.height(16.dp))


                    Text(
                        text = "Penguin Viewer",
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            }
        }


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(4f / 12f),
            contentAlignment = Alignment.Center
        ) {
            if (allLikesZero) {
                Card(
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                ) {

                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Like some penguins first ;)",
                            style = TextStyle(
                                fontSize = 48.sp,
                                fontWeight = MaterialTheme.typography.headlineMedium.fontWeight
                            ),
                            color = Color.Black
                        )
                    }
                }
            } else {

                mostLikedPenguin?.let { penguin ->
                    Card(
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(all = 10.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.secondaryContainer
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {

                            Text(
                                text = "Penguin Of The Day",
                                style = TextStyle(
                                    fontSize = 48.sp,
                                    fontWeight = MaterialTheme.typography.headlineMedium.fontWeight
                                ),
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            )

                            Row(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(top = 16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Image(
                                    painter = painterResource(id = penguin.imageRes),
                                    contentDescription = "Penguin Image",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .weight(1f)
                                        .clip(RoundedCornerShape(8.dp))
                                )


                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .weight(1f)
                                        .padding(start = 16.dp),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally // Wyśrodkowanie tekstu
                                ) {
                                    Text(
                                        text = "${penguin.title}",
                                        style = MaterialTheme.typography.headlineMedium
                                    )
                                    Text(
                                        text = "Region: ${penguin.region}",
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                    Text(
                                        text = "Population: ${penguin.population}",
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                    Text(
                                        text = "Likes: ${penguin.likes}",
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(6f / 12f),
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 50.dp),
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {
                items(items) { item ->
                    CardItemView(item = item, onClick = { onCardClick(item.id) })
                }
            }
        }
    }
}


