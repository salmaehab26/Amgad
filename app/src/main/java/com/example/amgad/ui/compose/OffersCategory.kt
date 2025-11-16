package com.example.amgad.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.amgad.R
import com.example.amgad.domain.model.OfferCategoryModel
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.LightGreen
import com.example.amgad.ui.theme.YankeesBlue
import com.example.amgad.ui.viewModel.OfferCategoryViewModel


@Composable
fun OffersCategoryPart( offersViewModel: OfferCategoryViewModel = hiltViewModel()) {
    val items by offersViewModel.offers.collectAsState()

    OffersCategory(items)
}
@Composable
fun OffersCategory(categories: List<OfferCategoryModel>) {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        Column(
            modifier = Modifier
                .height(170.dp)
        ) {

            // Title Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    text = "🛍️",
                    fontSize = 20.sp
                )
                Text(
                    text = "وين تحب توفر فلوسك؟",
                    fontSize = 16.sp,
                    fontFamily = Alexandria,
                    fontWeight = FontWeight.Bold,
                    color = YankeesBlue
                )
            }

            // Categories Horizontal List
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = androidx.compose.foundation.layout.PaddingValues(start = 10.dp, end = 10.dp)
            ) {
                items(categories) { category ->
                    CategoryItem(category)
                }
            }
        }
    }
}

@Composable
fun CategoryItem(category: OfferCategoryModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Box(
            modifier = Modifier
                .height(80.dp)
                .width(80.dp)
                .background(LightGreen, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = category.icon),
                contentDescription = category.title,
                modifier = Modifier.size(32.dp)
            )
        }

        Text(
            text = category.title,
            fontSize = 14.sp,
            color = YankeesBlue,
            fontFamily = Alexandria,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}
