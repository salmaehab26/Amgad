package com.example.amgad.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.amgad.ui.theme.CompanyColor
import com.example.amgad.ui.theme.GrayBodyTextColor
import com.example.amgad.ui.theme.YankeesBlue
@Composable
fun AlertDialogContent(onDismiss: () -> Unit) {
    Surface(
        shape = RoundedCornerShape(16.dp),
        color = Color.White,
        modifier = Modifier
            .width(380.dp)
            .wrapContentHeight()
            .padding(16.dp),
        shadowElevation = 8.dp
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .height(250.dp)
                    .width(250.dp),
                contentDescription = "Personality Discovery",
                painter = painterResource(id = R.drawable.illu_discover_your_personality)
            )

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "اكتشف ذاتك الحقيقية",
                fontSize = 24.sp,
                fontFamily = Alexandria,
                fontWeight = FontWeight.Bold,
                color = YankeesBlue,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            Text(
                text = "اكتب يوميًا حياتية للمالية لذاتك الحقيقة واكتشف\nأسرار سلوكك في غضون دقائق محدودة",
                fontSize = 14.sp,
                fontFamily = Alexandria,
                color = GrayBodyTextColor,
                textAlign = TextAlign.Center,
                lineHeight = 25.sp,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            Button(
                onClick = onDismiss,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = CompanyColor),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "اكتشف شخصيتك الآن",
                    fontSize = 18.sp,
                    fontFamily = Alexandria,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            TextButton(
                onClick = onDismiss,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.textButtonColors(
                    containerColor = CompanyColor.copy(alpha = 0.1f)
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "ذكّرني لاحقًا",
                    fontSize = 18.sp,
                    fontFamily = Alexandria,
                    color = CompanyColor
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}



//@Preview
//@Composable
//fun PreviewPersonalityDiscoveryScreen() {
//    MaterialTheme {
//        AlertDialog()
//    }
//}