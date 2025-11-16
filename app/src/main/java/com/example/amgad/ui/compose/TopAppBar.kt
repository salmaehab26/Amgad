package com.example.amgad.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amgad.R
import com.example.amgad.ui.theme.Alexandria

@Preview
@Composable
fun TopAppbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFAFAFA))
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        EndPartOfTopBar()
        Spacer(modifier = Modifier.weight(1f))

        StartPartOfTopBar()
        ProfileWithNotificationIcon()



    }


}

@Preview(showBackground = true)
@Composable
fun ProfileWithNotificationIcon() {
    Box(
        modifier = Modifier.size(55.dp).padding(end = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .drawBehind {
                    val strokeWidth = 6f
                    val radius = size.minDimension / 2 - strokeWidth / 2

                    drawCircle(
                        brush = Brush.radialGradient(
                            colors = listOf(
                                Color.Black.copy(alpha = 0.6f),
                                Color.Transparent
                            ),
                            center = Offset(size.width / 2, size.height / 2),
                            radius = radius + strokeWidth
                        ),
                        radius = radius,
                        style = Stroke(width = strokeWidth)
                    )
                },
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.amgad),
                contentDescription = "profile",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(45.dp)
            )
        }
        Box(
            modifier = Modifier
                .size(18.dp)
                .clip(CircleShape)
                .align(Alignment.BottomEnd)
                .background(Color.White),

            ) {
            Image(

                painter = painterResource(R.drawable.bell),
                contentDescription = "Notification",
                modifier = Modifier
                    .size(16.dp)
                    .align(Alignment.Center)
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartPartOfTopBar() {
    Column(modifier = Modifier.padding(end = 15.dp), horizontalAlignment = Alignment.End) {
        Row(verticalAlignment = Alignment.Bottom) {
            Image(
                painter = painterResource(id = R.drawable.img),
                modifier = Modifier.size(32.dp),
                contentDescription = "wave hand",

                )
            Text(
                "أهلاً, معاذ", fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Alexandria,
                color = Color(0XFF1C1E44),
                textAlign = TextAlign.End
            )
        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            "اليوم الأحد، 27/11/2024", fontWeight = FontWeight.Bold,
            color = Color(0XFF6B6D85),
            textAlign = TextAlign.End, fontFamily = Alexandria, fontSize = 11.sp

        )
    }

}

@Preview(showBackground = true)
@Composable
fun EndPartOfTopBar() {
    Row(modifier = Modifier.padding(start =5.dp)) {
        Column(
            modifier = Modifier.padding(end = 5.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "رصيد نقاطك", fontFamily = Alexandria, fontSize = 11.sp,
                fontWeight = FontWeight.Bold, color = Color(0XFF555673)
            )
            Text(
                "10,000", fontFamily = Alexandria, fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Image(
            painter = painterResource(id = R.drawable.ic_coins),
            contentDescription = null,
            modifier = Modifier
                .size(36.dp)
        )
    }

}