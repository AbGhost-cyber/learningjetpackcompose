package com.crushtech.composelearning.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.crushtech.composelearning.R

@Composable
fun ProfilePage() {
    Card(
        elevation = 6.dp,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp, start = 16.dp, end = 16.dp, bottom = 100.dp)
            .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(30.dp))
    ) {
        Column(
            Modifier.verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.kermit_the_frog),
                contentDescription = "Kermit the frog",
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
                    .border(
                        width = 3.dp,
                        color = Color.Red, shape = CircleShape
                    ),
            )
            Text(text = "German Kermit", fontWeight = FontWeight.ExtraBold)
            Text(text = "hello, welcome to my page")
            ProfileRow {
                ProfileStats(count = 15000, desc = "Followers")
                ProfileStats(count = 100, desc = "Following")
                ProfileStats(count = 13, desc = "Post")
                ProfileStats(count = 300, desc = "Saved")
            }
            ProfileRow {
                Button(onClick = {}) {
                    Text(text = "Follow user")
                }
                Button(onClick = {}) {
                    Text(text = "Direct Message")
                }
            }
        }
    }
}

@Composable
fun ProfileRow(content: @Composable RowScope.() -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        content()
    }
}

@Composable
fun ProfileStats(count: Int, desc: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "$count", fontWeight = FontWeight.Bold)
        Text(text = desc)
    }
}

@Composable
@Preview(showBackground = true)
fun ProfilePagePreview() {
    ProfilePage()
}
