package com.example.app1jetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailScreen(
    card: CardItem,
    onLikeClick: (Int) -> Unit
) {

    var likes by remember { mutableStateOf(card.likes) }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(vertical = 20.dp)) {
        // Top section (2/5 of the screen)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f / 5f),
            contentAlignment = Alignment.Center
        ) {
            Row(
                modifier = Modifier.fillMaxSize()
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Card(
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.fillMaxSize(),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                    ) {
                        Box(
                            modifier = Modifier
                                .padding(16.dp)
                        ) {

                            Image(
                                painter = painterResource(id = card.imageRes),
                                contentDescription = "Image inside card",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(8.dp)),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .padding(8.dp)
                ) {

                    Card(
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f / 10f)
                            .padding(bottom = 8.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
                    ) {

                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {
                            Text(
                                text = card.title,
                                modifier = Modifier.align(Alignment.Center),
                                style = MaterialTheme.typography.headlineLarge.copy(fontSize = 36.sp)
                            )
                        }
                    }

                    Card(
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(2f / 5f),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
                    ) {

                        Box(
                            modifier = Modifier
                                .fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .padding(16.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.Start
                            ) {

                                Text(
                                    text = "Nazwa łacińska: ${card.latin}",
                                    color = MaterialTheme.colorScheme.onTertiary,
                                    style = TextStyle(
                                        fontSize = 30.sp,
                                        fontWeight = MaterialTheme.typography.headlineMedium.fontWeight
                                    ),
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .weight(1f)
                                        .wrapContentHeight(Alignment.CenterVertically)
                                )


                                Text(
                                    text = "Populacja: ${card.population}",
                                    color = MaterialTheme.colorScheme.onTertiary,
                                    style = TextStyle(
                                        fontSize = 30.sp,
                                        fontWeight = MaterialTheme.typography.headlineMedium.fontWeight
                                    ),
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .weight(1f)
                                        .wrapContentHeight(Alignment.CenterVertically)
                                )

                                Text(
                                    text = "Region: ${card.region}",
                                    color = MaterialTheme.colorScheme.onTertiary,
                                    style = TextStyle(
                                        fontSize = 30.sp,
                                        fontWeight = MaterialTheme.typography.headlineMedium.fontWeight
                                    ),
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .weight(1f)
                                        .wrapContentHeight(Alignment.CenterVertically)
                                )


                                Text(
                                    text = "Waga: ${card.weight}",
                                    color = MaterialTheme.colorScheme.onTertiary,
                                    style = TextStyle(
                                        fontSize = 30.sp,
                                        fontWeight = MaterialTheme.typography.headlineMedium.fontWeight
                                    ),
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .weight(1f)
                                        .wrapContentHeight(Alignment.CenterVertically)
                                )


                                Text(
                                    text = "Wysokość: ${card.height}",
                                    color = MaterialTheme.colorScheme.onTertiary,
                                    style = TextStyle(
                                        fontSize = 30.sp,
                                        fontWeight = MaterialTheme.typography.headlineMedium.fontWeight
                                    ),
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .weight(1f)
                                        .wrapContentHeight(Alignment.CenterVertically)
                                )
                            }
                        }
                    }
                }
            }
        }


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f / 10f),
        ) {
            Card(
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
                    .clickable {
                        likes += 1
                        onLikeClick(card.id) // Notify parent composable if needed
                    },
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    // Heart icon
                    Image(
                        painter = painterResource(id = R.drawable.heart_angle_svgrepo_com),
                        contentDescription = "Heart icon",
                        modifier = Modifier
                            .size(70.dp)
                    )

                    Spacer(modifier = Modifier.width(8.dp))


                    Text(
                        text = "$likes",
                        style = TextStyle(
                            fontSize = 48.sp,
                            fontWeight = MaterialTheme.typography.headlineMedium.fontWeight
                        ),
                        color = MaterialTheme.colorScheme.onTertiaryContainer
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f / 5f)
                .padding(bottom = 30.dp)
                .verticalScroll(rememberScrollState()),
        ) {
            Text(
                text = card.description,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                style = TextStyle(
                    fontSize = 40.sp,
                    fontWeight = MaterialTheme.typography.headlineMedium.fontWeight),
                maxLines = Int.MAX_VALUE, // Nie ograniczaj liczby linii
                overflow = androidx.compose.ui.text.style.TextOverflow.Visible //
            )
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 800,
    heightDp = 1334
)
@Composable
fun PreviewDetailScreen() {
    // Example card item for preview
    val exampleCard = CardItem(
        imageRes = R.drawable.emperor,
        title = "Example Title",
        description = "Pingwiny cesarskie to największy gatunek pingwinów, znane ze swojej wyjątkowej zdolności do przetrwania w ekstremalnych warunkach Antarktydy. Są doskonałymi pływakami, spędzają większość życia w wodzie, polując na ryby, kałamarnice i kryl. Cechują się silnym instynktem ochrony potomstwa – samce wychowują jaja przez kilka miesięcy w mroźnym klimacie, trzymając je na stopach pod specjalną fałdą skóry. Ciekawostką jest, że pingwiny cesarskie potrafią nurkować na głębokość do 500 metrów.",
        region = "Australia",
        population = "100",
        likes = 0,
        id = 1,
        latin = "Totally Pengu",
        weight = "500lbs",
        height = "100cm"
    )


    DetailScreen(
        card = exampleCard,
        onLikeClick = {}
    )
}
