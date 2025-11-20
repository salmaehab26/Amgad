package com.example.amgad.ui.compose.HrRequestScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.CompanyColor
import com.example.amgad.ui.theme.HrCardTextColor
import com.example.amgad.ui.theme.HrRequestTabBackground

@Composable
fun TabsRow(
    tabs: List<String>,
    selectedTab: Int,
    onTabSelected: (Int) -> Unit
) {
    Box(
        modifier = Modifier
            .width(290.dp)
            .height(30.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(HrRequestTabBackground),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(2.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            tabs.forEachIndexed { index, title ->
                val isSelected = index == selectedTab

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(if (isSelected) Color.White else Color.Transparent)
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                        .clickable { onTabSelected(index) }
                ) {
                    Text(
                        text = title,
                        fontFamily = Alexandria,
                        fontSize = 14.sp,
                        color = if (isSelected) CompanyColor else HrCardTextColor
                    )
                }
            }
        }
    }
}