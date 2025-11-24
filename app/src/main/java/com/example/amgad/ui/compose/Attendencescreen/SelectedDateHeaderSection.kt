package com.example.amgad.ui.compose.Attendencescreen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.YankeesBlue
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SelectedDateHeaderSection(selectedDate: LocalDate) {
    Text(
        "${selectedDate.dayOfWeek.getDisplayName(TextStyle.FULL, Locale("ar"))}، " +
                "${selectedDate.dayOfMonth} " +
                selectedDate.month.getDisplayName(TextStyle.FULL, Locale("ar")) +
                " ${selectedDate.year}",
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = Alexandria,
        color = YankeesBlue,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}
