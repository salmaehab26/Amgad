package com.example.attendance

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.CompanyColor
import com.example.amgad.ui.theme.YankeesBlue
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.Locale

data class DayData(
    val date: LocalDate,
    val dayName: String,
    val dayNumber: Int
)

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AttendanceScreen() {
    var selectedDate by remember { mutableStateOf(LocalDate.now()) }
    val currentMonth = remember { YearMonth.now() }

    val daysInMonth = remember(currentMonth) {
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
                date = date,
                dayName = arabicDayNames[date.dayOfWeek.value] ?: "",
                dayNumber = day
            )
        }
    }

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFAF9F6))
                .padding(padding)
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp),
                horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    "سجل الحضور والتغيب",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center, fontFamily = Alexandria
                )
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Back",
                    tint = YankeesBlue,
                    modifier = Modifier
                        .height(24.dp)
                        .width(14.dp)
                )

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(Color(0xFFFFF8E1), RoundedCornerShape(8.dp))
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = null,
                        tint = Color(0xFFFFA726),
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        "إحصائيات الشهر",
                        color = Color(0xFFFFA726),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
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
                                TextStyle.FULL,
                                Locale("ar")
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
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 4.dp)
            ) {
                items(daysInMonth) { dayData ->
                    DayCard(
                        dayName = dayData.dayName,
                        dayNumber = dayData.dayNumber.toString(),
                        isSelected = dayData.date == selectedDate,
                        onClick = { selectedDate = dayData.date }
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Date title
            Text(
                "${
                    selectedDate.dayOfWeek.getDisplayName(
                        TextStyle.FULL,
                        Locale("ar")
                    )
                }، ${selectedDate.dayOfMonth} ${selectedDate.month.getDisplayName(
                    TextStyle.FULL,
                    Locale("ar"))} ${selectedDate.year}",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Time info box
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .border(1.dp, Color(0xFFE0E0E0), RoundedCornerShape(12.dp))
//                    .background(Color.White, RoundedCornerShape(12.dp))
//                    .padding(16.dp)
//            ) {
//                Column {
//                    Row(
//                        modifier = Modifier.fillMaxWidth(),
//                        horizontalArrangement = Arrangement.Center,
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        Text(
//                            "أوقات بدء الدوام",
//                            fontSize = 14.sp,
//                            color = Color.Gray
//                        )
//                        Spacer(modifier = Modifier.width(24.dp))
//                        Text(
//                            "صباحا 8:00",
//                            fontSize = 14.sp,
//                            fontWeight = FontWeight.Medium
//                        )
//                        Spacer(modifier = Modifier.width(8.dp))
//                        Text("•", color = Color.Gray)
//                        Spacer(modifier = Modifier.width(8.dp))
//                        Text(
//                            "مساءا 10:00",
//                            fontSize = 14.sp,
//                            fontWeight = FontWeight.Medium
//                        )
//                    }
//
//                    Spacer(modifier = Modifier.height(12.dp))
//
//                    Text(
//                        "الوقت المنقضي لاكمال ساعات العمل | 1 ساعة و 9 دقائق",
//                        fontSize = 13.sp,
//                        color = Color(0xFFD32F2F),
//                        modifier = Modifier.fillMaxWidth(),
//                        textAlign = TextAlign.Center
//                    )
//
//                    Spacer(modifier = Modifier.height(12.dp))
//
//                    Text(
//                        "تم التقديم على طلب اذن وتمت الموافقة عليه",
//                        fontSize = 13.sp,
//                        color = Color(0xFF4CAF50),
//                        modifier = Modifier.fillMaxWidth(),
//                        textAlign = TextAlign.Center
//                    )
//                }
//            }
//
//            Spacer(modifier = Modifier.height(24.dp))

            // Check-in times
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceEvenly
//            ) {
//                TimeCard(
//                    label = "وقت الحضور",
//                    time = "9:59 من",
//                    timeColor = Color(0xFF2196F3)
//                )
//
//                TimeCard(
//                    label = "وقت الانصراف",
//                    time = "4:50 م",
//                    timeColor = Color(0xFFD32F2F)
//                )
//            }
        }
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
                if (isSelected) Color(0xFFFFF8E1) else Color.White,
                RoundedCornerShape(12.dp)
            )
            .border(
                1.dp,
                if (isSelected) Color(0xFFFFA726) else Color(0xFFE0E0E0),
                RoundedCornerShape(12.dp)
            )
            .padding(vertical = 12.dp)
    ) {
        Text(
            dayName,
            fontSize = 12.sp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            dayNumber,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = if (isSelected) Color(0xFFFFA726) else Color.Black
        )
    }
}

@Composable
fun TimeCard(label: String, time: String, timeColor: Color) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(150.dp)
            .background(Color.White, RoundedCornerShape(12.dp))
            .border(1.dp, Color(0xFFE0E0E0), RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        Text(
            label,
            fontSize = 14.sp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = null,
                tint = Color.Gray,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                time,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = timeColor
            )
        }
    }
}