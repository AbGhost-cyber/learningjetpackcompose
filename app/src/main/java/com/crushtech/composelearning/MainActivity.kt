package com.crushtech.composelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crushtech.composelearning.ui.theme.ComposeLearningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLearningTheme {
                MyApp()
            }
        }
    }

    @Composable
    fun MyApp() {
        val (count, setCount) = remember { mutableStateOf(0) }
        Surface(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            color = Color(0xFF546E7A)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "$$count",
                    style = TextStyle(
                        fontSize = 35.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(40.dp))
                CreateCircle {
                    setCount(count + 1)
                }
            }
        }
    }

    @Composable
    fun CreateCircle(onClick: () -> Unit) {
        Card(
            modifier = Modifier
                .padding(3.dp)
                .size(105.dp)
                .clickable {
                    onClick.invoke()
                },
            shape = CircleShape, elevation = 5.dp

        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(text = "Tap")
            }
        }
    }
}
