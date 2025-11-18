package com.example.amgad.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.CardDefaults
import com.example.amgad.R
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.CompanyColor
import com.example.amgad.ui.theme.HrCardTextColor
import com.example.amgad.ui.theme.HrEquipmentBackground
import com.example.amgad.ui.theme.HrEquipmentBorder
import com.example.amgad.ui.theme.HrRequestProfileBorder
import com.example.amgad.ui.theme.HrRequestTabBackground
import com.example.amgad.ui.theme.HrWeHearYouBackground
import com.example.amgad.ui.theme.HrWeHearYouBorder
import com.example.amgad.ui.theme.YankeesBlue

@Preview(showBackground = true)
@Composable
fun MyLibraryScreen() {

    val tabs = listOf("مرفوضة", "مقبولة", "بانتظار موافقتك")
    var selectedTab by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F5FB))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
        ) {
            Image(painterResource(id = R.drawable.ic_filter), contentDescription = "filter")

            Text(
                text = "طلبات مرسلة إليك في انتظار قرارك",
                color = YankeesBlue,
                fontSize = 16.sp,
                fontFamily = Alexandria,

                )
            Image(painter = painterResource(id = R.drawable.ic_back), contentDescription = "back")
        }

        Box(
            modifier = Modifier
                .width(290.dp)
                .height(30.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(HrRequestTabBackground), contentAlignment = Alignment.Center
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
                            .background(
                                if (isSelected) Color.White
                                else Color.Transparent
                            )
                            .padding(horizontal = 12.dp, vertical = 4.dp)
                            .clickable { selectedTab = index }

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

        Spacer(modifier = Modifier.height(8.dp))

        // Request Cards
        RequestCard(
            title = "طلب عهدة",
            titleColor = HrEquipmentBackground,
            employeeName = "نورة إبراهيم",
            timeText = "تم إرسال الطلب منذ 1 نوفمبر 2024 - 9:01 ص",
            imageRes = R.drawable.amgad,
            borderColor = HrEquipmentBorder

        )

        Spacer(modifier = Modifier.height(16.dp))

        RequestCard(
            title = "نسمعك",
            titleColor = HrWeHearYouBackground,
            employeeName = "خالد المنصور",
            timeText = "تم إرسال الطلب منذ 3 نوفمبر 2024 - 12:47 م",
            imageRes = R.drawable.amgad,
            borderColor = HrWeHearYouBorder
        )
    }
}

@Composable
fun VideoCard(
    title: String,
    titleColor: Color,
    employeeName: String,
    timeText: String,
    imageRes: Int,
    borderColor: Color
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .padding(14.dp)
    ) {
        Column {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(titleColor, RoundedCornerShape(12.dp))
                    .padding(vertical = 14.dp, horizontal = 12.dp)
            ) {
                Text(
                    text = title,
                    fontFamily = Alexandria,
                    fontSize = 14.sp,
                    color = Color(0xFF5A3F3F),
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {

                Text(
                    text = employeeName,
                    fontSize = 15.sp,
                    fontFamily = Alexandria,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1A1A1A),
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 14.dp),
                    textAlign = TextAlign.End
                )

                Image(
                    painter = painterResource(id = imageRes), contentDescription = "Employee",

                    modifier = Modifier
                        .size(38.dp)
                        .clip(RoundedCornerShape(50))
                        .border(
                            color = HrRequestProfileBorder,
                            width = 1.dp,
                            shape = RoundedCornerShape(50)
                        )
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = timeText,
                fontSize = 12.sp,
                fontFamily = Alexandria,
                color = Color.Gray,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
            )
        }
    }
}
