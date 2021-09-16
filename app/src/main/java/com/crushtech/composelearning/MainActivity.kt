package com.crushtech.composelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painter = painterResource(id = R.drawable.kermit_the_frog)
            val description = "Kermit in the snow"
            val title = "Kermit is playing in the snow"

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(16.dp),
            ) {
                ImageCard(
                    painter = painter,
                    contentDescription = description,
                    title = title
                )
            }
//            Column(
//                modifier = Modifier
//                    .background(Color.Green)
//                    .fillMaxHeight(0.5f)
//                    .fillMaxWidth()
//                    .padding(10.dp)
//            ) {
//                Text(text = "Hello", modifier = Modifier.clickable {
//                    Toast.makeText(this@MainActivity, "clicked", Toast.LENGTH_SHORT).show()
//                })
//                Spacer(modifier = Modifier.height(50.dp))
//                Text(text = "World", Modifier.combinedClickable {
//                    Toast.makeText(this@MainActivity, "double clicked", Toast.LENGTH_SHORT).show()
//                })
//                //Greeting()
//            }
        }
    }
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black), startY = 300f
                        )
                    )
            )
            Text(
                text = title,
                modifier = modifier
                    .align(Alignment.BottomStart)
                    .padding(12.dp),
                style = TextStyle(color = Color.White, fontSize = 16.sp)
            )
        }
    }
}
