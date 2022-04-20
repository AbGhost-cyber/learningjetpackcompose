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
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
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
        BoxWithConstraints {
            val constraints = if (minWidth < 600.dp) {
                portraitConstraints(margin = 16.dp)
            } else {
                landscapeConstraints(margin = 16.dp)
            }
            ConstraintLayout(constraintSet = constraints) {
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
                        .layoutId("image"),
                )
                Text(
                    text = "German Kermit", fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.layoutId("nameText")
                )
                Text(
                    text = "hello, welcome to my page",
                    Modifier.layoutId("subText")
                )
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .layoutId("rowStats")
                ) {
                    ProfileStats(count = 15000, desc = "Followers")
                    ProfileStats(count = 100, desc = "Following")
                    ProfileStats(count = 13, desc = "Post")
                    ProfileStats(count = 300, desc = "Saved")
                }

                Button(
                    onClick = {},
                    Modifier.layoutId("btnFollow")
                ) {
                    Text(text = "Follow user")
                }
                Button(
                    onClick = {},
                    Modifier.layoutId("btnMsg")
                ) {
                    Text(text = "Direct Message")
                }
            }
        }
    }
}

private fun landscapeConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val image = createRefFor("image")
        val nameText = createRefFor("nameText")
        val subText = createRefFor("subText")
        val rowStats = createRefFor("rowStats")
        val btnFollow = createRefFor("btnFollow")
        val btnMsg = createRefFor("btnMsg")

        constrain(image) {
            top.linkTo(parent.top, margin)
            start.linkTo(parent.start, margin)
        }
        constrain(nameText) {
            start.linkTo(image.start)
            top.linkTo(image.bottom)
        }
        constrain(subText) {
            top.linkTo(nameText.bottom)
            start.linkTo(nameText.start)
            end.linkTo(nameText.end)
        }
        constrain(rowStats) {
            top.linkTo(image.top)
            start.linkTo(image.end, margin)
            end.linkTo(parent.end)
        }
        constrain(btnFollow) {
            top.linkTo(rowStats.bottom, margin = margin)
            start.linkTo(rowStats.start)
            end.linkTo(btnMsg.start)
            bottom.linkTo(subText.bottom)
            width = Dimension.wrapContent
        }
        constrain(btnMsg) {
            top.linkTo(rowStats.bottom, margin = margin)
            start.linkTo(btnFollow.end)
            end.linkTo(parent.end)
            bottom.linkTo(subText.bottom)
            width = Dimension.wrapContent
        }
    }
}

private fun portraitConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val image = createRefFor("image")
        val guideLine = createGuidelineFromTop(0.1f)
        val nameText = createRefFor("nameText")
        val subText = createRefFor("subText")
        val rowStats = createRefFor("rowStats")
        val btnFollow = createRefFor("btnFollow")
        val btnMsg = createRefFor("btnMsg")

        constrain(image) {
            top.linkTo(guideLine)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(nameText) {
            top.linkTo(image.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(subText) {
            top.linkTo(nameText.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(rowStats) {
            top.linkTo(nameText.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(btnFollow) {
            top.linkTo(rowStats.bottom, margin = margin)
            start.linkTo(parent.start)
            end.linkTo(btnMsg.start)
            width = Dimension.wrapContent
        }
        constrain(btnMsg) {
            top.linkTo(rowStats.bottom, margin = margin)
            start.linkTo(btnFollow.end)
            end.linkTo(parent.end)
            width = Dimension.wrapContent
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
