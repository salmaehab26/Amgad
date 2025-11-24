package com.example.attendance

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp

import com.example.amgad.domain.model.AttendenceModel.DayData
import com.example.amgad.ui.compose.Attendencescreen.DayCard
import com.example.amgad.ui.compose.Attendencescreen.ElapsedWorkTimeCardSection
import com.example.amgad.ui.compose.Attendencescreen.MonthStatsSection
import com.example.amgad.ui.compose.Attendencescreen.PermissionStatusSection
import com.example.amgad.ui.compose.Attendencescreen.RecordsSection
import com.example.amgad.ui.compose.Attendencescreen.SelectedDateHeaderSection
import com.example.amgad.ui.compose.Attendencescreen.TopHeaderSection
import com.example.amgad.ui.compose.Attendencescreen.WorkStartTimesCardSection

import com.example.amgad.ui.theme.WhiteBackground
import java.time.LocalDate


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AttendanceScreen(onNavigateBack: () -> Unit) {
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }
    val listState = rememberLazyListState()
    val today = LocalDate.now()



    val daysInMonth = remember {
        (-15..15).map { day ->
            val date = today.plusDays(day.toLong())
            val arabicDayNames = mapOf(
                1 to "الاثنين", 2 to "الثلاثاء", 3 to "الأربعاء",
                4 to "الخميس", 5 to "الجمعة", 6 to "السبت", 7 to "الأحد"
            )
            DayData(date, arabicDayNames[date.dayOfWeek.value] ?: "", date.dayOfMonth  )
        }
    }

    LaunchedEffect(Unit) {
        val todayIndex = daysInMonth.indexOfFirst { it.date == today }.coerceAtLeast(0)
        val centerOffset = 2
        val target = (todayIndex - centerOffset).coerceIn(0, daysInMonth.lastIndex)
        listState.scrollToItem(target)
    }

    LaunchedEffect(selectedDate) {
        val index = daysInMonth.indexOfFirst { it.date == selectedDate }
        if (index != -1) {
            val centerOffset = 2
            val target = (index - centerOffset).coerceIn(0, daysInMonth.lastIndex)
            listState.animateScrollToItem(target)
        }
    }
    Column(
        modifier = Modifier.fillMaxSize().background(WhiteBackground), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clip(
                    RoundedCornerShape(
                        bottomStart = 20.dp, bottomEnd = 20.dp
                    )
                )
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFFFFFEFD), Color(0xFFFAF6E7)
                        )
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                TopHeaderSection(onNavigateBack = onNavigateBack)

                MonthStatsSection(selectedDate = selectedDate)
                Spacer(modifier = Modifier.height(16.dp))

                LazyRow(
                    state =listState,
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(horizontal = 4.dp)
                ) {
                    items(daysInMonth) { dayData ->
                        DayCard(
                            dayName = dayData.dayName,
                            dayNumber = dayData.dayNumber.toString(),
                            isSelected = dayData.date == selectedDate,
                            onClick = { selectedDate = dayData.date })
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(24.dp))

        SelectedDateHeaderSection(selectedDate = selectedDate)
        Spacer(modifier = Modifier.height(16.dp))

        WorkStartTimesCardSection()
        Spacer(modifier = Modifier.height(12.dp))

        ElapsedWorkTimeCardSection()


        Spacer(modifier = Modifier.height(12.dp))

        PermissionStatusSection()
        Spacer(modifier = Modifier.height(55.dp))

        RecordsSection()




    }

}



