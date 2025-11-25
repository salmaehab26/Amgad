package com.example.amgad.ui.compose.HrRequestDetailsScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.GrayBodyTextColor

import com.example.amgad.ui.theme.YankeesBlue

@Composable
fun OrderDatesSection(time: String, borderColor: Long) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth().height(61.dp)
            .background(White, RoundedCornerShape(10.dp))
            .border(1.dp, Color(borderColor), RoundedCornerShape(10.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OrderDateItem("تاريخ الرد على الطلب", time,   Modifier.weight(1f)
            .padding(12.dp))
        VerticalDivider(Modifier.height(27.dp))
        OrderDateItem("تاريخ ارسال الطلب", time,   Modifier.weight(1f)
            .padding(12.dp))
    }


}
@Composable
private fun OrderDateItem(title: String, value: String,modifier: Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier

    ) {
        Text(title, color = GrayBodyTextColor, fontSize = 11.sp, fontFamily = Alexandria)
        Text(value, color = YankeesBlue, fontSize = 11.sp, fontFamily = Alexandria)
    }
}

