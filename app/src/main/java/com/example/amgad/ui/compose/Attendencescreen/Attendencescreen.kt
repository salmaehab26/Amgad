package com.example.attendance

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amgad.R
import com.example.amgad.ui.compose.Attendencescreen.TopHeaderSection
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.CalendarDayBackgroundSelected
import com.example.amgad.ui.theme.CalendarDayBorder
import com.example.amgad.ui.theme.CalendarDayBorderSelected
import com.example.amgad.ui.theme.CalendarDayText
import com.example.amgad.ui.theme.CalendarDayTextNum
import com.example.amgad.ui.theme.CompanyColor
import com.example.amgad.ui.theme.GrayBodyTextColor
import com.example.amgad.ui.theme.PermeationCard
import com.example.amgad.ui.theme.PermeationCardText
import com.example.amgad.ui.theme.RecordCard
import com.example.amgad.ui.theme.RecordCardText
import com.example.amgad.ui.theme.SignInTime
import com.example.amgad.ui.theme.SignOutTime
import com.example.amgad.ui.theme.TimeCard
import com.example.amgad.ui.theme.TimeCardBorder
import com.example.amgad.ui.theme.TimeCardText
import com.example.amgad.ui.theme.YankeesBlue
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.Locale

data class DayData(
    val date: LocalDate, val dayName: String, val dayNumber: Int
)

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AttendanceScreen(onNavigateBack: () -> Unit) {
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }
    val currentMonth = remember { YearMonth.now() }
    val listState = rememberLazyListState()



    val daysInMonth = run {
        val daysCount = currentMonth.lengthOfMonth()
        (1..daysCount).map { day ->
            val date = LocalDate.of(currentMonth.year, currentMonth.month, day)
            val arabicDayNames = mapOf(
                1 to "الاثنين",
                2 to "الثلاثاء",
                3 to "الأربعاء",
                4 to "الخميس",
                5 to "الجمعة",
                6 to "السبت",
                7 to "الأحد"
            )
            DayData(
                date = date, dayName = arabicDayNames[date.dayOfWeek.value] ?: "", dayNumber = day
            )
        }
    }

    LaunchedEffect(Unit) {
        val todayIndex = LocalDate.now().dayOfMonth - 1
        listState.scrollToItem(
            index = todayIndex,
            scrollOffset = -300
        )}
    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
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

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                    ) {

                        Text(
                            "إحصائيات الشهر",
                            color = Color(0xFFFFA726),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        )
                        Spacer(modifier = Modifier.width(4.dp))

                        Image(
                            painter = painterResource(id = R.drawable.ic_attendance_stats),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = null,
                            tint = CompanyColor,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            " ${
                                selectedDate.month.getDisplayName(
                                    TextStyle.FULL, Locale("ar")
                                )
                            } ${selectedDate.year}",
                            color = CompanyColor,
                            fontSize = 14.sp,
                            fontFamily = Alexandria,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }

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

        Text(
            "${
                selectedDate.dayOfWeek.getDisplayName(
                    TextStyle.FULL, Locale("ar")
                )
            }، ${selectedDate.dayOfMonth} ${
                selectedDate.month.getDisplayName(
                    TextStyle.FULL, Locale("ar")
                )
            } ${selectedDate.year}",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = Alexandria,
            color = YankeesBlue,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(

            modifier = Modifier
                .width(280.dp)
                .height(45.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.White)
                .drawBehind {
                    val strokeWidth = 3.dp.toPx()
                    val dashWidth = 4.dp.toPx()
                    val dashGap = 4.dp.toPx()

                    drawRoundRect(
                        color = Color(0xFFE0E0E0),
                        size = size,
                        cornerRadius = CornerRadius(10.dp.toPx()),
                        style = Stroke(
                            width = strokeWidth, pathEffect = PathEffect.dashPathEffect(
                                floatArrayOf(dashWidth, dashGap), 0f
                            )
                        )
                    )
                }, contentAlignment = Alignment.Center
        ) {
            Column(verticalArrangement = Arrangement.Center) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "مساءا",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = Alexandria,
                        color = GrayBodyTextColor,
                    )

                    Text(
                        " 10:00",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Alexandria,
                        color = GrayBodyTextColor,
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(":", color = GrayBodyTextColor)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        "صباحا ",
                        fontSize = 11.sp,
                        fontFamily = Alexandria, color = GrayBodyTextColor,
                    )


                    Text(
                        " 8:00",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Alexandria, color = GrayBodyTextColor,
                    )

                    Text(
                        ": أوقات بدء الدوام", fontSize = 11.sp, fontWeight = FontWeight.Medium,

                        color = GrayBodyTextColor, fontFamily = Alexandria
                    )
                }


            }

        }
        Spacer(modifier = Modifier.height(12.dp))

        Box(
            modifier = Modifier
                .width(320.dp)
                .height(45.dp)
                .clip(RoundedCornerShape(22.dp))
                .background(color = TimeCard)
                .border(color = TimeCardBorder, width = 1.dp),
            Alignment.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    " دقائق",
                    fontSize = 13.sp,
                    fontFamily = Alexandria,
                    color = TimeCardText,
                )
                Text(
                    " 9 ",
                    fontSize = 16.sp,
                    fontFamily = Alexandria,
                    color = TimeCardText,

                    )
                Text(
                    "ساعة و  ",
                    fontFamily = Alexandria,
                    fontSize = 11.sp,
                    color = TimeCardText,
                )
                Text(
                    "1  ",
                    fontSize = 16.sp,
                    fontFamily = Alexandria,
                    color = TimeCardText,

                    )


                Text(
                    ":الوقت المنقضي لاكمال ساعات العمل",
                    fontFamily = Alexandria,
                    fontSize = 11.sp,
                    color = TimeCardText,
                )
            }

        }


        Spacer(modifier = Modifier.height(12.dp))

        Box(
            modifier = Modifier
                .width(250.dp)
                .height(30.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(color = PermeationCard),
            Alignment.Center
        ) {
            Text(
                "تم التقديم على طلب اذن وتمت الموافقة عليه",
                fontSize = 11.sp,
                color = PermeationCardText,
                fontFamily = Alexandria,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(60.dp))
        Column(

        ) { Row {

            Text(
                "وقت الانصراف",
                color = RecordCardText,
                textAlign = TextAlign.End,
                modifier = Modifier.width(200.dp)
            )
            Text(
                "وقت الانصراف",
                color = RecordCardText,
                textAlign = TextAlign.End,
                modifier = Modifier.width(180.dp)
            )}
            Row (   horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .height(55.dp)
                    .background(RecordCard, RoundedCornerShape(12.dp))
            ){   TimeCard(
                time = "م4:50 "
            )
                TimeCard(
                    time = "م4:50 "
                )
            }}




    }

}

@Composable
fun DayCard(dayName: String, dayNumber: String, isSelected: Boolean, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(onClick = onClick)
            .width(66.dp)
            .background(
                if (isSelected) CalendarDayBackgroundSelected
                else Color.White, RoundedCornerShape(12.dp)
            )
            .border(
                1.dp,
                if (isSelected) CalendarDayBorderSelected else CalendarDayBorder,
                RoundedCornerShape(6.dp)
            )
            .padding(vertical = 12.dp)
    ) {
        Text(
            dayName,
            fontSize = 11.sp,
            color = CalendarDayText, fontFamily = Alexandria,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            dayNumber,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = Alexandria,
            color = if (isSelected) Color.Black else CalendarDayTextNum
        )
    }
}

@Composable
fun TimeCard(time: String) {

    Row(
        modifier = Modifier.fillMaxHeight(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(horizontalAlignment = Alignment.End) {
            Row(
                modifier = Modifier.width(176.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {

                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = null,
                    tint = RecordCardText,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    time, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = SignOutTime
                )
            }

        }
        Column(horizontalAlignment = Alignment.End) {
            Row(
                modifier = Modifier.width(175.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    time, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = SignInTime
                )
            }
        }
    }

}