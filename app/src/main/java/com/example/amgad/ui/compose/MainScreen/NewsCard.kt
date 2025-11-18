package com.example.amgad.ui.compose.MainScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.amgad.domain.model.NewsCardModel
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.GrayBodyTextColor
import com.example.amgad.ui.theme.YankeesBlue
import com.example.amgad.ui.viewModel.NewsViewModel
@Preview
@Composable
fun NewsCardPart(newsViewModel: NewsViewModel = hiltViewModel()) {
    val items by newsViewModel.news.collectAsState()

    NewsCard(items)
}


@Composable
fun NewsCard(news: List<NewsCardModel>){
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(horizontal = 4.dp)
        ) {
            items(news) { new ->
                NewsCardItem(new)
            }
        }
    }
}
@Composable
fun NewsCardItem(news: NewsCardModel) {
    Card(
        modifier = Modifier.padding( 10.dp)
            .width(280.dp)
            .height(190.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = news.image),
                contentDescription = news.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)),
                contentScale = ContentScale.Crop
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(White)
                    .padding(12.dp), Arrangement.SpaceBetween
            ) {
                Text(
                    text = news.title,
                    fontSize = 14.sp,
                    fontFamily = Alexandria,
                    color = YankeesBlue,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(6.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Views",
                        modifier = Modifier.size(14.dp),
                        tint = Color(0xFF999999)
                    )
                    Text(
                        text = news.views.toString(),
                        fontSize = 14.sp,
                        fontFamily = Alexandria,
                        color = GrayBodyTextColor,
                    )
                }
            }
        }
    }
}