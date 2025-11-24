package com.example.amgad.ui.compose.MainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material.icons.filled.LocationOn
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
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.amgad.R
import com.example.amgad.domain.model.MainModle.MostUsedOfferModel
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.GrayBodyTextColor
import com.example.amgad.ui.theme.YankeesBlue
import com.example.amgad.ui.viewModel.HomeViewModel.MostUsedOfferViewModel

@Composable
fun MostUsedOffersPart(
    mostUsedOffersViewModel: MostUsedOfferViewModel = hiltViewModel(),
    navigatDocumentAtachement: () -> Unit
) {
    val items by mostUsedOffersViewModel.offers.collectAsState()

    MostUsedOffers(items, navigatDocumentAtachement)
}

@Composable
fun MostUsedOffers(offers: List<MostUsedOfferModel>, navigatDocumentAtachement: () -> Unit) {


    Column(
        modifier = Modifier.height(260.dp), horizontalAlignment = Alignment.End

    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {

            Text(
                text = "أكثر شي مطلوب الفترة هذي",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = YankeesBlue,
                fontFamily = Alexandria,
                modifier = Modifier.clickable(onClick = navigatDocumentAtachement)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_trending),
                contentDescription = "Trending",
                modifier = Modifier.size(20.dp)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(215.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.Bottom,
            ) {
                items(offers) { offer ->
                    OfferCard(
                        offer = offer,

                        )
                }
            }
        }
    }
}


@Composable
fun OfferCard(
    offer: MostUsedOfferModel, modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .height(212.dp)
            .width(200.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {

        Box {
            Column(modifier = Modifier.fillMaxSize()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp)
                ) {
                    Image(
                        painter = painterResource(offer.image),
                        contentDescription = offer.storeName,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                }



                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(White)
                        .padding(top=16.dp,end=10.dp,start=10.dp,bottom=10.dp),
                    Arrangement.Center
                ) {

                    Text(
                        text = offer.description,
                        fontSize = 14.sp,
                        color = YankeesBlue,
                        fontFamily = Alexandria,
                        maxLines = 1, fontWeight = FontWeight.Bold,
                        overflow = TextOverflow.Ellipsis

                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "Location",
                            modifier = Modifier.size(14.dp),
                            tint = Color(0xFF999999)
                        )
                        Text(
                            text = offer.location,
                            fontSize = 11.sp,
                            color = GrayBodyTextColor,
                            fontFamily = Alexandria
                        )
                    }
                }
            }

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.CenterStart,
            ) {
                Row(verticalAlignment = Alignment.Bottom) {
                    Image(
                        painter = painterResource(R.drawable.offer_image3),
                        contentDescription = "Discount",
                        modifier = Modifier
                            .size(65.dp)
                            .padding(8.dp)
                            .clip(CircleShape)
                            .background(White, CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        modifier = Modifier.padding(bottom = 5.dp),
                        text = offer.storeName,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = GrayBodyTextColor,
                        fontFamily = Alexandria,
                    )
                }

            }

        }
    }
}

