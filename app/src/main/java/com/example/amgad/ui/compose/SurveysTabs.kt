package com.example.amgad.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
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
import com.example.amgad.R
import com.example.amgad.domain.model.NewsCardModel
import com.example.amgad.domain.model.TabItemModel
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.GrayBodyTextColor
import com.example.amgad.ui.theme.YankeesBlue

@Preview
@Composable
fun SurveysTabs() {
    val tabs = listOf(
        TabItemModel("أخبار الدار", 12, true),
        TabItemModel("استبياناتي", 9, false),
        TabItemModel("مكتبتي", 3, false)
    )

    val newsItems = listOf(
        NewsCardModel(
            R.drawable.offer_image, "كيف استفيد من برنامج إمداد", 198
        ), NewsCardModel(
            R.drawable.offer_image2, "إيجاد وطن شك", 245
        ), NewsCardModel(
            R.drawable.offer_image3, "التطوير المستمر", 320
        )
    )
Spacer(modifier = Modifier.height(20.dp))
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))

        ) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                tabs.forEach { tab ->
                    TabBox(
                        title = tab.title,
                        count = tab.count,
                        isSelected = tab.isSelected,
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))


        }
    }
}

@Composable
fun TabBox(
    title: String, count: Int, isSelected: Boolean, modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(40.dp)
            .width(120.dp)
            .background(White, RoundedCornerShape(8.dp))
            .border(
                width = if (isSelected) 2.dp else 1.dp,
                color = if (isSelected) Color(0xFFFF6B6B) else Color(0xFFE0E0E0),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(5.dp), contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp)

        ) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(
                        if (isSelected) Color(0xFFFF6B6B) else Color(0xFF9E9E9E), CircleShape
                    ), contentAlignment = Alignment.Center
            ) {
                Text(
                    text = count.toString(),
                    color = White,
                    fontSize = 13.sp,
                    fontFamily = Alexandria
                )
            }
            Text(
                text = title,
                fontSize = 14.sp,
                color = if (isSelected) Color(0xFF333333) else Color(0xFF666666),
                fontFamily = Alexandria,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}
