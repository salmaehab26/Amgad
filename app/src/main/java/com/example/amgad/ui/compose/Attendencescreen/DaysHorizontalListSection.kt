//package com.example.amgad.ui.compose.Attendencescreen
//
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.lazy.LazyListState
//import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.foundation.lazy.items
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import com.example.amgad.domain.model.Attendencescreen.DayData
//import java.time.LocalDate
//
//@Composable
//fun DaysHorizontalListSection(
//    daysInMonth: List<DayData>,
//    selectedDate: LocalDate,
//    listState: LazyListState,
//    onDaySelected: (LocalDate) -> Unit
//) {
//    LazyRow(
//        state = listState,
//        modifier = Modifier.fillMaxWidth(),
//        horizontalArrangement = Arrangement.spacedBy(8.dp),
//        verticalAlignment = Alignment.CenterVertically,
//        contentPadding = PaddingValues(horizontal = 4.dp)
//    ) {
//        items(daysInMonth) { day ->
//            DayCard(
//                dayName = day.dayName,
//                dayNumber = day.dayNumber.toString(),
//                isSelected = day.date == selectedDate,
//                onClick = { onDaySelected(day.date) }
//            )
//        }
//    }
//}
