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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.amgad.R
import com.example.amgad.ui.compose.HrRequestDetailsScreen.OrderDatesSection
import com.example.amgad.ui.compose.HrRequestDetailsScreen.OrderHeader
import com.example.amgad.ui.compose.HrRequestDetailsScreen.OrderRejectReasonSection
import com.example.amgad.ui.compose.HrRequestDetailsScreen.OrderStatusSection
import com.example.amgad.ui.compose.HrRequestDetailsScreen.OrderUserSection
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.GrayBodyTextColor
import com.example.amgad.ui.theme.YankeesBlue
import com.example.amgad.ui.viewModel.HrRequestDetailsScreenViewModel.HrRequestScreenDetailsViewModel
@Composable
fun OrderDetailsScreen(viewModel: HrRequestScreenDetailsViewModel = hiltViewModel(),
                       onNavigateBack: () -> Unit){
    OrderDetailsScreenContent(
        name = viewModel.name,
        time = viewModel.time,
        typeTitle = viewModel.typeTitle,
        statusName = viewModel.statusName,
        TitleColor = viewModel.TitleColor,
        backgroundColor = viewModel.backgroundColor,
        borderColor = viewModel.borderColor,
        onNavigateBack = onNavigateBack
    )
}


@Composable
fun OrderDetailsScreenContent(
    name: String,
    time: String,
    typeTitle: String,
    statusName: String,
    TitleColor: Long,
    backgroundColor: Long,
    borderColor: Long,
    onNavigateBack: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OrderHeader(onNavigateBack)

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
        OrderDatesSection(time, borderColor)
        Spacer(modifier = Modifier.height(4.dp))
        OrderUserSection(name)
        OrderStatusSection()
        Spacer(modifier = Modifier.height(8.dp))
        OrderRejectReasonSection()
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
                    Column(
                        horizontalAlignment = Alignment.End,
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 12.dp)
                    ) {
                        Text(
                            "مدير القسم", color = GrayBodyTextColor,
                            fontSize = 11.sp,
                            fontFamily = Alexandria
                        )
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
                    "تاريخ الموافقة",
                    color = GrayBodyTextColor,
                    fontSize = 11.sp,
                    fontFamily = Alexandria
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
