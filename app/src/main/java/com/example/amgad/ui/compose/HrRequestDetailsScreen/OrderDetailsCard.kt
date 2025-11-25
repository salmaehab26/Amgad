package com.example.amgad.ui.compose.HrRequestDetailsScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amgad.ui.theme.GrayBodyTextColor

import com.example.amgad.ui.theme.YankeesBlue

@Composable
fun OrderDetailsCard() {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(173.dp),
        colors = CardDefaults.cardColors(containerColor = White),
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.End) {

            Text("العهدة المطلوبة", color = GrayBodyTextColor, fontSize = 11.sp)
            Text("طباعة مكتبية", color = YankeesBlue, fontSize = 16.sp)

            Spacer(Modifier.height(33.dp))

            Text("ملاحظات", fontSize = 11.sp, color = GrayBodyTextColor)
            Text(
                "أود طلب طابعة مكتبية ...",
                color = YankeesBlue,
                fontSize = 16.sp,
                textAlign = TextAlign.End
            )
        }
    }
}
