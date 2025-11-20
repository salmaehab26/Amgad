package com.example.amgad.ui.compose
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amgad.R
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.GrayBodyTextColor
import com.example.amgad.ui.theme.HrEquipmentBackground
import com.example.amgad.ui.theme.HrEquipmentBorder
import com.example.amgad.ui.theme.HrEquipmentText
import com.example.amgad.ui.theme.HrTimeBorder
import com.example.amgad.ui.theme.HrUserBackground
import com.example.amgad.ui.theme.HrUserBorder
import com.example.amgad.ui.theme.LogOutRed

import com.example.amgad.ui.theme.YankeesBlue

@Composable
fun OrderDetailsScreen(name: String,
                       time: String,
                       typeTitle: String,
                       statusName : String,
                       TitleColor: Long,
                       backgroundColor: Long,
                       borderColor: Long,
                       onNavigateBack: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(45.dp)

        ) {
            Text(
                text = "تفاصيل الطلب",
                color = YankeesBlue,
                fontSize = 16.sp,
                fontFamily = Alexandria,
                textAlign = TextAlign.Center,

                )
            Spacer(modifier = Modifier.width(120.dp))
            Image(
                modifier = Modifier
                    .height(24.dp)
                    .width(14.dp)
                    .clickable {onNavigateBack},
                painter = painterResource(R.drawable.ic_back),
                contentDescription = "رجوع"
            )
        }

        Box(
            modifier = Modifier
                .padding(
                    start = 12.dp, top = 25.dp, end = 12.dp, bottom = 10.dp
                )
                .fillMaxWidth()
                .height(55.dp)
                .background(Color(backgroundColor), shape = RoundedCornerShape(10.dp))
                .border(
                    color = Color(borderColor), width = 1.dp, shape = RoundedCornerShape(10.dp)
                ), contentAlignment = Alignment.Center
        ) {
            Text(
                typeTitle, color = Color(TitleColor), fontFamily = Alexandria,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .background(
                    White, shape = RoundedCornerShape(10.dp)
                )
                .border(
                    width = 1.dp, color = Color(borderColor), shape = RoundedCornerShape(10.dp)
                ), verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 12.dp, vertical = 16.dp)
            ) {
                Text(
                    "تاريخ الرد على الطلب",
                    fontSize = 11.sp,
                    color = GrayBodyTextColor,
                    fontFamily = Alexandria,
                )
                Text(
                    time,
                    fontSize = 11.sp,
                    fontFamily = Alexandria,
                    color = YankeesBlue,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 25.sp
                )
            }

            VerticalDivider(
                Modifier.height(27.dp), DividerDefaults.Thickness, DividerDefaults.color
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 12.dp, vertical = 16.dp)
            ) {
                Text(
                    "تاريخ ارسال الطلب",
                    fontSize = 11.sp,
                    color = GrayBodyTextColor,

                    fontFamily = Alexandria,
                )
                Text(
                    time,
                    fontSize = 11.sp,
                    fontFamily = Alexandria,
                    color = YankeesBlue,
                    lineHeight = 25.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .background(
                    HrUserBackground,
                    shape = RoundedCornerShape(10.dp)
                )
                .border(
                    width = 1.dp,
                    color = HrUserBorder,
                    shape = RoundedCornerShape(10.dp)
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,

            ) {
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    "مقدم الطلب",
                    fontSize = 11.sp,
                    color = GrayBodyTextColor,
                    fontFamily = Alexandria
                )
                Text(name, fontSize = 16.sp, fontFamily = Alexandria, color = YankeesBlue)
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


        Box(
            modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center

        ) {

            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(), thickness = 2.dp, color = HrTimeBorder
            )
            Row(
                modifier = Modifier
                    .height(32.dp)
                    .width(137.dp)
                    .background(Color(HrEquipmentBackground), shape = RoundedCornerShape(20.dp))
                    .border(
                        color = Color(HrEquipmentBorder), width = 1.dp, shape = RoundedCornerShape(20.dp)
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text("طلب مرفوض", color = LogOutRed, fontFamily = Alexandria, fontSize = 14.sp)

                Spacer(modifier = Modifier.width(4.dp))
                Image(
                    painter = painterResource(R.drawable.cancelled_session_ic),
                    contentDescription = null
                )
            }
        }


        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(110.dp)
                .background(
                    White, shape = RoundedCornerShape(10.dp)
                )
                .border(
                    width = 1.dp, color = HrTimeBorder, shape = RoundedCornerShape(10.dp)
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {

            Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.End) {
                Text(
                    "سبب رفض الطلب",
                    fontSize = 11.sp,
                    color = GrayBodyTextColor,
                    fontFamily = Alexandria
                )
                Text(
                    "نعتذر، لا يمكن توفير طابعة في الوقت الحالي نظرًا لتوفر أجهزة طباعة مشتركة في المكتب",
                    fontSize = 16.sp,
                    lineHeight = 26.sp,
                    color = YankeesBlue,
                    textAlign = TextAlign.End,
                    fontFamily = Alexandria
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            "تفاصيل الطلب",
            fontSize = 18.sp, fontFamily = Alexandria,
            fontWeight = FontWeight.Bold,
            color = YankeesBlue,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp),
            textAlign = TextAlign.End
        )
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(173.dp),
            colors = CardDefaults.cardColors(containerColor = White),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(3.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.End) {

                Text(
                    "العهدة المطلوبة",
                    color = GrayBodyTextColor,
                    fontSize = 11.sp,
                    fontFamily = Alexandria
                )
                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    "طباعة مكتبية",
                    color = YankeesBlue,
                    fontSize = 16.sp,
                    fontFamily = Alexandria,
                )


                Spacer(modifier = Modifier.height(33.dp))

                Text(
                    "ملاحظات", color = GrayBodyTextColor, fontSize = 11.sp, fontFamily = Alexandria
                )
                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    "أود طلب طابعة مكتبية للاستخدام في مهام العمل. شكرًا لكم",
                    color = YankeesBlue,
                    fontSize = 16.sp,
                    fontFamily = Alexandria,
                    textAlign = TextAlign.End,
                    lineHeight = 25.sp
                )
            }

        }

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            "موافقة مدير قسم الموظف",
            fontSize = 18.sp,
            fontFamily = Alexandria,
            fontWeight = FontWeight.Bold,
            color = YankeesBlue,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 16.dp),
            textAlign = TextAlign.End
        )
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(146.dp),
            colors = CardDefaults.cardColors(containerColor = White),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(3.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.End) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(horizontalAlignment = Alignment.End, modifier = Modifier.weight(1f).padding(end =12.dp)) {
                        Text("مدير القسم",  color = GrayBodyTextColor,
                    fontSize = 11.sp,
                    fontFamily = Alexandria)
                        Text("منصور الغامدي", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFD0D0D0)), contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Default.Person, contentDescription = null, tint = Color.Gray)
                    }
                }
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    "تاريخ الموافقة", color = GrayBodyTextColor, fontSize = 11.sp, fontFamily = Alexandria
                )
                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    "1 نوفبر 2024 - 10:08 ص",
                    color = YankeesBlue,
                    fontSize = 16.sp,
                    fontFamily = Alexandria,
                    textAlign = TextAlign.End,
                    lineHeight = 25.sp
                )
            }
        }
    }

}
