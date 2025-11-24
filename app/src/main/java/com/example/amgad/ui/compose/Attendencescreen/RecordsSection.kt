package com.example.amgad.ui.compose.Attendencescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.amgad.ui.theme.RecordCard
import com.example.amgad.ui.theme.RecordCardText

@Preview(showBackground = true)
@Composable
fun RecordsSection() {
    Column {
        Row (horizontalArrangement = Arrangement.End){
            Text(
                "وقت الانصراف",
                color = RecordCardText,
                modifier = Modifier.width(200.dp), textAlign= TextAlign.End
            )
            Text(
                "وقت الحضور",
                color = RecordCardText,
                modifier = Modifier.width(180.dp), textAlign= TextAlign.End
            )
        }

        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .height(55.dp)
                .background(RecordCard, RoundedCornerShape(4.dp)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TimeCard()
        }
    }
}
