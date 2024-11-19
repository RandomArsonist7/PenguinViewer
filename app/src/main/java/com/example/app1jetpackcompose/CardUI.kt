package com.example.app1jetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardItemView(item: CardItem, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 10.dp)
            .clickable { onClick() } // Obsługa kliknięcia
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = item.imageRes),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(8.dp))
            )


            Spacer(modifier = Modifier.width(16.dp))


            Text(
                text = item.title,
                style = TextStyle(
                    fontSize = 48.sp,
                    fontWeight = MaterialTheme.typography.headlineMedium.fontWeight
                ),
                modifier = Modifier.weight(1f)
            )


            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.heart_angle_svgrepo_com),
                    contentDescription = "Heart Icon",
                    modifier = Modifier.size(72.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "${item.likes}",
                    style = TextStyle(
                        fontSize = 48.sp,
                        fontWeight = MaterialTheme.typography.headlineMedium.fontWeight
                    ),
                )
            }
        }
    }
}