package com.example.amgad.ui.compose.Attendencescreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.CalendarDayBackgroundSelected
import com.example.amgad.ui.theme.CalendarDayBorder
import com.example.amgad.ui.theme.CalendarDayBorderSelected
import com.example.amgad.ui.theme.CalendarDayText
import com.example.amgad.ui.theme.CalendarDayTextNum

@Composable
fun DayCard(
    dayName: String,
    dayNumber: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(66.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) CalendarDayBackgroundSelected else Color.White
        ),
        border = BorderStroke(
            1.dp,
            if (isSelected) CalendarDayBorderSelected else CalendarDayBorder
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
    ) {

    Column(
            modifier = Modifier.padding(vertical = 12.dp).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = dayName,
                fontSize = 11.sp,
                fontFamily = Alexandria,
                color = CalendarDayText
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = dayNumber,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Alexandria,
                color = if (isSelected) Color.Black else CalendarDayTextNum
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Try(){

    DayCard("الاتنين","24",true,{})
}