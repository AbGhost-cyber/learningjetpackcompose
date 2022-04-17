package com.crushtech.composelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crushtech.composelearning.ui.ProfilePage
import com.crushtech.composelearning.ui.theme.ComposeLearningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLearningTheme {
                Surface(color = MaterialTheme.colors.background) {
                    ProfilePage()
                }
            }

//            var countrState by remember {
//                mutableStateOf(0)
//            }
//            val painter = painterResource(id = R.drawable.kermit_the_frog)
//            val description = "Kermit in the snow"
//            val title = "Kermit is playing in the snow"

//            Box(
//                modifier = Modifier
//                    .fillMaxWidth(0.5f)
//                    .padding(16.dp),
//            ) {
//                ImageCard(
//                    painter = painter,
//                    contentDescription = description,
//                    title = title
//                )
//            }

//            Column(
//                modifier = Modifier
//                    .fillMaxHeight()
//                    .padding(20.dp)
//            ) {
//                NamesList(modifier = Modifier.weight(1f), List(1000) { "Hello Android $it" })
//                Counter(counter = counterState, updateCount = {
//                    counterState = it
//                })
//            }
        }
    }
}

@Composable
fun NamesList(
    modifier: Modifier = Modifier,
    names: List<String>,
) {
    LazyColumn(modifier = modifier) {
        items(items = names) {
            Greeting(name = it)
            Divider()
        }
    }
}

@Composable
fun Counter(counter: Int, updateCount: (Int) -> Unit) {
    Button(onClick = { updateCount(counter + 1) }) {
        Text(text = "I've been clicked $counter times")
    }
}

@Composable
fun Greeting(name: String) {
    var isSelected by remember {
        mutableStateOf(false)
    }
    val targetColor by animateColorAsState(
        targetValue = if (isSelected) MaterialTheme.colors.primary else Color.Transparent,
        animationSpec = tween(durationMillis = 700)
    )
    Surface(color = targetColor) {
        Text(
            text = "Hello $name!",
            modifier = Modifier
                .clickable { isSelected = !isSelected }
                .padding(16.dp)
        )
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
