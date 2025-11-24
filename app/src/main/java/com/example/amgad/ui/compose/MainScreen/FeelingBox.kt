package com.example.amgad.ui.compose.MainScreen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amgad.R
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.CompanyColor
import kotlinx.coroutines.delay

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun FeelingBox(modifier: Modifier = Modifier) {

    var isVisible by remember { mutableStateOf(true) }

    val images = listOf(
        R.drawable.emoji_sad,
        R.drawable.emoji_anxious,
        R.drawable.emoji_happy,
        R.drawable.emoji_angry,
        R.drawable.emoji_exhausted,
        R.drawable.emoji_enthusiastic
    )

    var currentIndex by remember { mutableStateOf(0) }

    LaunchedEffect(currentIndex) {
        delay(2000)
        currentIndex = (currentIndex + 1) % images.size
    }

    if (isVisible) {
        Box(
            modifier = modifier
                .padding(16.dp)
                .width(260.dp)
                .height(56.dp)
                .background(CompanyColor, RoundedCornerShape(45.dp))
                .padding(horizontal = 10.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Icon(
                    Icons.Default.Close,
                    contentDescription = null,
                    tint = White,
                    modifier = Modifier
                        .size(22.dp)
                        .clickable { isVisible = false }
                )

                Text(
                    text = "ما هو شعورك اليوم؟",
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center,
                    color = White,
                    fontSize = 16.sp,
                    fontFamily = Alexandria
                )

                Box(
                    modifier = Modifier.height(60.dp).width(56.dp),
                    contentAlignment = Alignment.Center
                ) {
                    AnimatedContent(
                        targetState = currentIndex,
                        transitionSpec = {
                            (slideInVertically(initialOffsetY = { 60 }) + fadeIn()).togetherWith(
                                slideOutVertically(targetOffsetY = { -60 }) + fadeOut()
                            )
                        },
                        label = ""
                    ) { index ->
                        Image(
                            painter = painterResource(images[index]),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                }
            }
        }
    }
}
