package com.example.amgad.ui.compose.MainScreen

import com.example.amgad.ui.viewModel.SliderViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import kotlin.math.absoluteValue

@Preview(showBackground = true)
@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImageSliderCard(viewModel: SliderViewModel = hiltViewModel()) {
    val images by viewModel.images.collectAsState()

    val pagerState = rememberPagerState()

    LaunchedEffect(images.size) {
        if (images.isNotEmpty()) {
            val middlePage = images.size / 2
            pagerState.scrollToPage(middlePage)
        }
    }

    Row(Modifier.padding(top = 20.dp)) {

        HorizontalPager(
            count = images.size,
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 60.dp),
            modifier = Modifier.fillMaxSize()
        ) { page ->

            val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue.coerceIn(0f, 1f)

            val scale = 0.87f + (1f - pageOffset) * 0.2f

            Card(
                shape = RoundedCornerShape(15.dp),

                modifier = Modifier
                    .graphicsLayer {
                        scaleX = scale
                        scaleY = scale
                    }
                    .fillMaxWidth()
                    .aspectRatio(1.9f),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)) {
                Image(
                    painter = painterResource(id = images[page].resId),
                    contentDescription = "Image $page",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .clip(RoundedCornerShape(15.dp))
                        .fillMaxSize()
                )
            }
        }
    }

}
