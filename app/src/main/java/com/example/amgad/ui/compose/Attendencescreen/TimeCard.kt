package com.example.amgad.ui.compose.Attendencescreen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.HrRequestCardBorder
import com.example.amgad.ui.theme.RecordCardText
import com.example.amgad.ui.theme.SignInTime
import com.example.amgad.ui.theme.SignOutTime

@Preview(showBackground = true)
@Composable
fun TimeCard() {

    Row(
        modifier = Modifier.fillMaxHeight(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(horizontalAlignment = Alignment.End) {
            Row(
                modifier = Modifier.width(176.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Box(
                    modifier = Modifier
                        .width(34.dp)
                        .height(34.dp)
                        .border(1.dp, HrRequestCardBorder, shape = RoundedCornerShape(5.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = null,
                        tint = RecordCardText,
                        modifier = Modifier.size(20.dp)
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "م ", fontSize = 14.sp, color = SignOutTime, fontFamily = Alexandria
                )
                Text(
                    " 4:50", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = SignOutTime
                )
            }

        }
        Column(horizontalAlignment = Alignment.End) {
            Row(
                modifier = Modifier.width(175.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Box(
                    modifier = Modifier
                        .width(34.dp)
                        .height(34.dp)
                        .border(1.dp, HrRequestCardBorder, shape = RoundedCornerShape(5.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = null,
                        tint = RecordCardText,
                        modifier = Modifier.size(20.dp)
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "ص ", fontSize = 14.sp, color = SignInTime, fontFamily = Alexandria
                )
                Text(
                    " 9:59", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = SignInTime
                )

            }
        }
    }

}
