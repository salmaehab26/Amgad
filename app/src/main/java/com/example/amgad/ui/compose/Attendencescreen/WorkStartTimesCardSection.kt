package com.example.amgad.ui.compose.Attendencescreen

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amgad.R

import com.example.amgad.ui.compose.Attendencescreen.WorkStartTimesCardSection
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

@Composable
fun WorkStartTimesCardSection() {
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
                        width = strokeWidth,
                        pathEffect = PathEffect.dashPathEffect(
                            floatArrayOf(dashWidth, dashGap), 0f
                        )
                    )
                )
            },
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("مساءا", fontSize = 11.sp, color = GrayBodyTextColor, fontFamily = Alexandria)
            Text(" 10:00", fontSize = 16.sp, color = GrayBodyTextColor, fontFamily = Alexandria)
            Spacer(modifier = Modifier.width(8.dp))
            Text(":", color = GrayBodyTextColor, fontFamily = Alexandria)
            Spacer(modifier = Modifier.width(8.dp))
            Text("صباحا ", fontSize = 11.sp, color = GrayBodyTextColor, fontFamily = Alexandria)
            Text(" 8:00", fontSize = 16.sp, color = GrayBodyTextColor, fontFamily = Alexandria)
            Text(": أوقات بدء الدوام", fontSize = 11.sp, color = GrayBodyTextColor, fontFamily = Alexandria)
        }
    }
}
