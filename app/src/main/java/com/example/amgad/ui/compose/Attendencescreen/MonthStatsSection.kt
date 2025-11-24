package com.example.amgad.ui.compose.Attendencescreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amgad.R
import com.example.amgad.ui.theme.Alexandria

import com.example.amgad.ui.theme.CompanyColor
import com.example.amgad.ui.theme.MonthStatsSectionText

import java.time.LocalDate
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MonthStatsSection(selectedDate: LocalDate) {
    Row(
        modifier = Modifier.
        fillMaxWidth().
        padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("إحصائيات الشهر", color = MonthStatsSectionText, fontSize = 14.sp, fontFamily = Alexandria)
            Spacer(modifier = Modifier.width(4.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_attendance_stats),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = null,
                tint = CompanyColor,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                " ${selectedDate.month.getDisplayName(TextStyle.FULL, Locale("ar"))} ${selectedDate.year}",
                color = CompanyColor,
                fontSize = 14.sp,
                fontFamily = Alexandria
            )
        }
    }
}
