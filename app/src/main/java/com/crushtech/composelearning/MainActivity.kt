package com.crushtech.composelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crushtech.composelearning.ui.theme.ComposeLearningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLearningTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MyLazyColumn()
                }
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
//                Text(
//                    text = "$$count",
//                    style = TextStyle(
//                        fontSize = 35.sp,
//                        fontWeight = FontWeight.Bold
//                    )
//                )
//                Spacer(modifier = Modifier.height(40.dp))
//                CreateCircle {
//                    setCount(count + 1)
//                }
            }
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    fun MyLazyColumn() {
        val personList = arrayListOf<Person>()
        for (i in 1..10) {
            personList.add(Person(id = i, firstName = "Abundance", lastName = "Udo", age = i + 20))
        }
        val sections = listOf("A", "B", "C", "D", "E", "F", "G")
        LazyColumn(
            contentPadding = PaddingValues(all = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            sections.forEach { section ->
                stickyHeader {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Black)
                            .padding(12.dp),
                        text = "Section $section",
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
                items(personList) { person ->
                    ListItem(person = person)
                }
            }
        }
    }

    data class Person(
        val id: Int,
        val firstName: String,
        val lastName: String,
        val age: Int
    )

    @Composable
    fun ListItem(person: Person) {
        Row(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth()
                .padding(24.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${person.age}",
                fontSize = MaterialTheme.typography.h4.fontSize,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = person.firstName,
                color = Color.Black,
                fontSize = MaterialTheme.typography.h5.fontSize,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = person.lastName,
                color = Color.Red,
                fontSize = MaterialTheme.typography.h5.fontSize,
                fontWeight = FontWeight.Normal
            )
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
            shape = CircleShape,
            elevation = 5.dp

        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(text = "Tap")
            }
        }
    }

    @Composable
    fun RowScope.CustomItem(weight: Float, color: Color) {
        Surface(
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .padding(start = 5.dp, end = 5.dp)
                .weight(weight),
            color = color,
            elevation = 5.dp
        ) {}
    }

    @Composable
    fun CreateRectangle() {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomItem(1f, MaterialTheme.colors.secondary)
            CustomItem(1f, MaterialTheme.colors.primary)
        }
    }

    @Composable
    fun MyBox() {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = stringResource(id = R.string.app_name),
                modifier = Modifier
                    .background(MaterialTheme.colors.primary)
                    .padding(16.dp),
                color = Color.White,
                fontSize = MaterialTheme.typography.h5.fontSize,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.End
            )
            CustomText()
        }
    }

    @Composable
    fun CustomText() {
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Red,
                        fontWeight = FontWeight.Bold,
                        fontSize = 40.sp
                    )
                ) {
                    append("A")
                }
                withStyle(style = ParagraphStyle()) {
                }
                append("B")
                append("C")
                append("D")
            },
            modifier = Modifier.width(200.dp)
        )
    }
}
