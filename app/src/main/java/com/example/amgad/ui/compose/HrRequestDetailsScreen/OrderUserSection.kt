package com.example.amgad.ui.compose.HrRequestDetailsScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.GrayBodyTextColor
import com.example.amgad.ui.theme.HrUserBackground
import com.example.amgad.ui.theme.HrUserBorder

import com.example.amgad.ui.theme.YankeesBlue

@Composable
fun OrderUserSection(name: String) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(HrUserBackground, RoundedCornerShape(10.dp))
            .border(1.dp, HrUserBorder, RoundedCornerShape(10.dp)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Column(horizontalAlignment = Alignment.End) {
            Text("مقدم الطلب", color = GrayBodyTextColor, fontSize = 11.sp, fontFamily = Alexandria)
            Text(name, fontSize = 16.sp, color = YankeesBlue, fontFamily = Alexandria)
        }

        Box(
            modifier = Modifier
                .padding(15.dp)
                .size(48.dp)
                .clip(CircleShape)
                .background(Color(0xFFD0D0D0)),
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Default.Person, contentDescription = null, tint = Color.Gray)
        }
    }
}
