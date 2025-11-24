package com.example.amgad.ui.compose.MainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amgad.R
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.CompanyColor
import com.example.amgad.ui.theme.GrayBodyTextColor
import com.example.amgad.ui.theme.YankeesBlue






@Composable
fun PersonlityTest(onClick: () -> Unit) {
    Spacer(modifier = Modifier.height(10.dp))
    Card(
        modifier = Modifier
            .padding(16.dp)
            .height(165.dp),
        colors = CardDefaults.cardColors(
            containerColor = White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)

    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 18.dp, vertical = 16.dp)
                .fillMaxWidth()
        ) {
            Image(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp),
                painter = painterResource(id = R.drawable.illu_discover_your_personality),
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    "اكتشف ذاتك الحقيقية",
                    color = YankeesBlue,
                    fontSize = 18.sp,
                    fontFamily = Alexandria,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    "اكتسب فهماً دقيقاً للغاية لذاتك الحقيقية واكتشف أسرار سلوكك في غضون دقائق معدودة",
                    color = GrayBodyTextColor,
                    fontSize = 11.sp,
                    fontFamily = Alexandria,
                    textAlign = TextAlign.End,
                    style = TextStyle(
                        lineHeight = 16.sp,
                    ),
                    modifier = Modifier.padding(start = 10.dp)

                )
                Spacer(modifier = Modifier.height(15.dp))

                Button(
                    modifier = Modifier
                        .height(36.dp)
                        .widthIn(min = 165.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = CompanyColor),
                    shape = RoundedCornerShape(6.dp),
                    onClick = {
                        onClick()
                    }) {
                    Text(
                        text = "اكتشف شخصيتك الآن", fontSize = 14.sp,
                        fontFamily = Alexandria,
                        textAlign = TextAlign.End,


                        )
                }
            }
        }


    }
}

