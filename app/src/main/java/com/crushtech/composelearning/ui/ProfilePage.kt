package com.crushtech.composelearning.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
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
        ConstraintLayout {
            val guideLine = createGuidelineFromTop(0.1f)
            val (image, nameText, subText, rowStats, btnFollow, btnMsg) = createRefs()
            Image(
                painter = painterResource(id = R.drawable.kermit_the_frog),
                contentDescription = "Kermit the frog",
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
                    .border(
                        width = 3.dp,
                        color = Color.Red, shape = CircleShape
                    )
                    .constrainAs(image) {
                        top.linkTo(guideLine)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    },
            )
            Text(
                text = "German Kermit", fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.constrainAs(nameText) {
                    top.linkTo(image.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )
            Text(
                text = "hello, welcome to my page",
                modifier = Modifier.constrainAs(subText) {
                    top.linkTo(nameText.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .constrainAs(rowStats) {
                        top.linkTo(subText.bottom)
                    }
            ) {
                ProfileStats(count = 15000, desc = "Followers")
                ProfileStats(count = 100, desc = "Following")
                ProfileStats(count = 13, desc = "Post")
                ProfileStats(count = 300, desc = "Saved")
            }

            Button(
                onClick = {},
                modifier = Modifier.constrainAs(btnFollow) {
                    top.linkTo(rowStats.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(btnMsg.start)
                    width = Dimension.wrapContent
                }
            ) {
                Text(text = "Follow user")
            }
            Button(
                onClick = {},
                Modifier.constrainAs(btnMsg) {
                    top.linkTo(rowStats.bottom, margin = 16.dp)
                    start.linkTo(btnFollow.end)
                    end.linkTo(parent.end)
                    width = Dimension.wrapContent
                }
            ) {
                Text(text = "Direct Message")
            }
        }
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
