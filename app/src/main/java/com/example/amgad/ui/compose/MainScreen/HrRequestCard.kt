package com.example.amgad.ui.compose.MainScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.amgad.R
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.HrRequestCardBorder
import com.example.amgad.domain.model.MainModle.HrRequestModel
import com.example.amgad.ui.viewModel.HomeViewModel.HrRequestViewModel

@Composable
fun HrRequestCard(viewModel: HrRequestViewModel= hiltViewModel()) {
    val items by viewModel.items.collectAsState()

    HrRequestCardContent(items)
}

@Composable
fun HrRequestCardContent(items: List<HrRequestModel>) {
    Card(
        border = BorderStroke(
            color = HrRequestCardBorder,
            width = 1.dp,

            ),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Column(
            modifier = Modifier.padding(18.dp), Arrangement.Top,
        ) {


            Spacer(modifier = Modifier.height(12.dp))
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(40.dp),
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(items) { item ->
                        HrRequestItemBox(item)
                    }
                }
            }
        }
    }
}

@Composable
fun HrRequestItemBox(item: HrRequestModel) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(item.color, RoundedCornerShape(8.dp))

        ) {
            Icon(
                painter = painterResource(id = item.icon),
                contentDescription = "Requests Icon",
                tint = White,
                modifier = Modifier
                    .size(20.dp)
                    .align(Alignment.Center),

                )
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(

            text = item.title, fontSize = 11.sp, color = Color.Black, fontFamily = Alexandria
        )
        Spacer(modifier = Modifier.height(15.dp))

    }
}

@Preview(showBackground = true)
@Composable
fun HrRequestCardPreview() {
    val mockItems = listOf(
        HrRequestModel("Vacation", Color(0xFFFFCDD2),R.drawable.ic_we_hear_you),
        HrRequestModel("Overtime", Color(0xFFBBDEFB),R.drawable.ic_we_hear_you),
        HrRequestModel("Attendance", Color(0xFFC8E6C9),R.drawable.ic_we_hear_you),
        HrRequestModel("Mission", Color(0xFFFFF9C4),R.drawable.ic_we_hear_you)
    )
    HrRequestCardContent(mockItems)
}
