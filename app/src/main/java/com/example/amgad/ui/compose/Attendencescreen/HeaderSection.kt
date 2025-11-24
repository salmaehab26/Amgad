//package com.example.amgad.ui.compose.Attendencescreen
//
//import android.os.Build
//import androidx.annotation.RequiresApi
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyListState
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import com.example.amgad.domain.model.DayData
//import java.time.LocalDate
//
//@RequiresApi(Build.VERSION_CODES.O)
//@Composable
//fun HeaderSection(
//    selectedDate: LocalDate,
//    daysInMonth: List<DayData>,
//    listState: LazyListState,
//    onNavigateBack: () -> Unit,
//    onDaySelected: (LocalDate) -> Unit
//) {
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(250.dp)
//            .clip(RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))
//            .background(
//                Brush.verticalGradient(
//                    listOf(Color(0xFFFFFEFD), Color(0xFFFAF6E7))
//                )
//            )
//    ) {
//        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
//
//            TopHeaderSection(onNavigateBack)
//
//            MonthStatsSection(selectedDate)
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            DaysHorizontalListSection(
//                daysInMonth = daysInMonth,
//                selectedDate = selectedDate,
//                listState = listState,
//                onDaySelected = onDaySelected
//            )
//        }
//    }
//}
