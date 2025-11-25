package com.example.amgad.ui.compose.HrRequestDetailsScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amgad.R
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.HrEquipmentBackground
import com.example.amgad.ui.theme.HrEquipmentBorder
import com.example.amgad.ui.theme.HrTimeBorder
import com.example.amgad.ui.theme.LogOutRed

@Composable
fun OrderStatusSection() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        HorizontalDivider(Modifier.fillMaxWidth(), 2.dp, HrTimeBorder)

        Row(
            modifier = Modifier
                .height(32.dp)
                .width(137.dp)
                .background(Color(HrEquipmentBackground), RoundedCornerShape(20.dp))
                .border(1.dp, Color(HrEquipmentBorder), RoundedCornerShape(20.dp)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text("طلب مرفوض", color = LogOutRed, fontFamily = Alexandria, fontSize = 14.sp)
            Spacer(Modifier.width(4.dp))
            Image(painterResource(R.drawable.cancelled_session_ic), null)
        }
    }
}
