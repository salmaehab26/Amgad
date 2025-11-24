package com.example.amgad.ui.compose.MainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amgad.R
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.CompanyColor
import com.example.amgad.ui.theme.Gray
import com.example.amgad.ui.theme.HrCardTextColor
import com.example.amgad.ui.theme.YellowBorder

@Composable
fun HrCard(onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp,)
            .height(130.dp)
            .border(
                color = YellowBorder, width = 1.dp, shape = RoundedCornerShape(10.dp)
            ),
        colors = CardDefaults.cardColors(
            containerColor = White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),


        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 15.dp, top = 8.dp).clickable(onClick=onClick)
            ) {
                Text(
                    "غير مسموح بتسجيل الحضور عبر هذا الجوال لأنه لم يتم تسجيله بعد لدى إدارة الموارد البشرية",
                    fontSize = 14.sp,
                    fontFamily = Alexandria,
                    textAlign = TextAlign.End,
                    color = HrCardTextColor,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        lineHeight = 20.sp
                    )
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 14.dp)
                ) {
                    Image(
                        painter =painterResource(R.drawable.arrow_ic) ,
                        contentDescription = null,
                        modifier = Modifier
                            .size(25.dp)
                            .padding(5.dp)
                    )
                    Text(
                        "ارسال طلب لتسجيل هذا الجوال",
                        color = CompanyColor,
                        fontSize = 14.sp,
                        fontFamily = Alexandria,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Image(
                painter = painterResource(id = R.drawable.not_allowed_phone_illu),
                contentDescription = null,
                Modifier
                    .height(85.dp)
                    .width(76.dp)
            )

        }
    }

}

