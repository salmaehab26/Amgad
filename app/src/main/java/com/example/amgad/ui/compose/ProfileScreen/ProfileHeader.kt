package com.example.amgad.ui.compose.ProfileScreen

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amgad.R
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.CompanyColor
import com.example.amgad.ui.theme.GrayBodyTextColor
import com.example.amgad.ui.theme.ProfileBoxLocationBackground
import com.example.amgad.ui.theme.WhiteBackground
import com.example.amgad.ui.theme.YankeesBlue
@Preview(showBackground = true)
@Composable
fun ProfileHeader() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Box(
                modifier = Modifier.size(130.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .height(100.dp)
                        .width(100.dp)
                        .clip(CircleShape).background(Color(0xFFE8E8E8)),

                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "م", fontSize = 26.sp, fontFamily = Alexandria, color = YankeesBlue,fontWeight = FontWeight.Bold)


                }
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .align(Alignment.BottomCenter)
                        .background(White),

                    ) {
                    Image(

                        painter = painterResource(R.drawable.camera_fill),
                        contentDescription = "camera",
                        modifier = Modifier
                            .size(20.dp)
                            .align(Alignment.Center)
                    )


                }
            }


            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "عمرو عبد الله",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Alexandria,
                color = YankeesBlue
            )

            Spacer(modifier = Modifier.height(40.dp))
            Row(
                modifier = Modifier
                    .width(300.dp)
                    .height(60.dp)
                    .background(WhiteBackground),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "رعاية للتأمينات",
                    fontSize = 18.sp,
                    color = YankeesBlue,
                    fontFamily = Alexandria
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_company_default_logo),
                    contentDescription = "company",
                )
            }

            Row(
                modifier = Modifier
                    .width(300.dp)
                    .height(30.dp)
                    .background(CompanyColor.copy(0.1f)),
                Arrangement.Center,
                Alignment.CenterVertically
            ) {
                Text(
                    text = "التأمين الصحي ",
                    fontSize = 11.sp,
                    color = YankeesBlue,
                    fontFamily = Alexandria
                )
                Text(
                    text = ":قسم",
                    fontSize = 11.sp,
                    color = GrayBodyTextColor,
                    fontFamily = Alexandria

                )

            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .width(300.dp)
                    .height(90.dp)
                    .background(ProfileBoxLocationBackground)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.sign_in_out_location),
                    contentDescription = "location",
                    Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "النطاق الجغرافي لتسجيل الحضور والانصراف فيه",
                    fontSize = 11.sp,
                    fontFamily = Alexandria,
                    color = GrayBodyTextColor,
                    lineHeight = 18.sp

                )
                Text(
                    text = "فرع الرياض الرئيسي",
                    fontSize = 11.sp,
                    fontFamily = Alexandria,
                    color = YankeesBlue,
                    lineHeight = 18.sp
                )
            }


        }}

}

