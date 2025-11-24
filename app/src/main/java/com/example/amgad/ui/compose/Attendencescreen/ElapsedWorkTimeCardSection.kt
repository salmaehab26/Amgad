package com.example.amgad.ui.compose.Attendencescreen


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.TimeCard
import com.example.amgad.ui.theme.TimeCardBorder
import com.example.amgad.ui.theme.TimeCardText


@Composable
fun ElapsedWorkTimeCardSection() {
    Box(
        modifier = Modifier
            .width(320.dp)
            .height(45.dp)
            .clip(RoundedCornerShape(22.dp))
            .background(TimeCard)
            .border(1.dp, TimeCardBorder, RoundedCornerShape(22.dp)),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(" دقائق", color = TimeCardText, fontFamily = Alexandria)
            Text(" 9 ", fontSize = 16.sp, color = TimeCardText, fontFamily = Alexandria)
            Text("ساعة و  ", fontSize = 11.sp, color = TimeCardText, fontFamily = Alexandria)
            Text("1  ", fontSize = 16.sp, color = TimeCardText, fontFamily = Alexandria)
            Text(":الوقت المنقضي لاكمال ساعات العمل", fontSize = 11.sp, color = TimeCardText, fontFamily = Alexandria)
        }
    }
}
