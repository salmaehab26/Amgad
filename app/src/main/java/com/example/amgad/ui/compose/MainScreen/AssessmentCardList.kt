package com.example.amgad.ui.compose.MainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.amgad.R
import com.example.amgad.domain.model.MainModle.AssessmentModel
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.AssessmentCardGrayText
import com.example.amgad.ui.viewModel.HomeViewModel.AssessmentsViewModel

@Composable
fun AssessmentCard(viewModel: AssessmentsViewModel= hiltViewModel()) {
    val items by viewModel.assessments.collectAsState()
    AssessmentCardList(items)
}


@Composable
fun AssessmentCardList(items: List<AssessmentModel>) {

    val gradientColors = listOf(
        listOf(Color(0xFFEF5350), Color(0xFFFF8A80)),
        listOf(Color(0xFFAB47BC), Color(0xFFE1BEE7)),
        listOf(Color(0xFF42A5F5), Color(0xFF90CAF9))
    )

    LazyRow(
        reverseLayout = true,
        horizontalArrangement = Arrangement.spacedBy(5.dp),
    ) {
        itemsIndexed(items) { index, item ->

            val colors = gradientColors[index % gradientColors.size]

            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {

                Card(
                    elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                    modifier = Modifier
                        .height(170.dp)
                        .width(170.dp)
                        .padding(end = 10.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                brush = Brush.horizontalGradient(colors),
                                shape = RoundedCornerShape(16.dp)
                            )
                    ) {

                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth()
                                .height(110.dp)
                        ) {

                            Image(
                                painter = painterResource(id = item.imageRes),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(70.dp)
                                    .height(70.dp)
                            )

                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Bottom,
                                horizontalAlignment = Alignment.End,
                            ) {
                                Text(
                                    text ="مقياس",
                                    fontFamily = Alexandria,
                                    fontSize = 13.sp
                                )
                                Text(
                                    text = item.title,
                                    fontFamily = Alexandria,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.End
                                )
                            }
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color = White)
                                .height(50.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {

                            Text(
                                "دقائق ",
                                fontSize = 11.sp,
                                fontFamily = Alexandria,
                                color = AssessmentCardGrayText
                            )
                            Text(
                                "${item.minutes} ",
                                fontSize = 14.sp,
                                fontFamily = Alexandria,
                                fontWeight = FontWeight.Bold
                            )
                            Image(
                                painter = painterResource(id = R.drawable.clock),
                                contentDescription = null,
                                modifier = Modifier.size(15.dp)
                            )

                            Spacer(modifier = Modifier.width(10.dp))

                            Text(
                                "أسئلة ",
                                fontSize = 11.sp,
                                fontFamily = Alexandria,
                                color = AssessmentCardGrayText
                            )
                            Text(
                                "${item.questions} ",
                                fontSize = 14.sp,
                                fontFamily = Alexandria,
                                fontWeight = FontWeight.Bold
                            )
                            Image(
                                painter = painterResource(id = R.drawable.question),
                                contentDescription = null,
                                modifier = Modifier.size(15.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}
