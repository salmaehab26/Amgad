package com.example.amgad.ui.compose.HrRequestScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amgad.R
import com.example.amgad.domain.model.HrRequestModel.HrRequestItemsScreenModel
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.GrayBodyTextColor
import com.example.amgad.ui.theme.HrRequestProfileBorder
import com.example.amgad.ui.theme.WhiteBackground
import com.example.amgad.ui.theme.YankeesBlue

@Composable
fun RequestCard(
    item: HrRequestItemsScreenModel,
    onCardClick: () -> Unit
) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .padding(14.dp)
            .clickable(
                enabled = true,
                onClick = onCardClick
            ), elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp

    ), colors = CardDefaults.cardColors(WhiteBackground), ){
        Column (modifier = Modifier.padding(16.dp)){

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(51.dp)
                    .border(1.dp, Color(item.type.borderColor), RoundedCornerShape(12.dp))
                    .background(color = Color(item.type.backgroundColor), RoundedCornerShape(12.dp))
                    .padding(vertical = 14.dp, horizontal = 12.dp)
            ) {
                Text(
                    text = item.type.title,
                    fontFamily = Alexandria,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(item.type.titleColor),
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
                    text = item.name,
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
                    painter = painterResource(id = R.drawable.amgad),
                    contentDescription = "Employee",

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
            Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically){
                Text(
                    text = item.time,
                    fontSize = 11.sp,
                    fontFamily = Alexandria,
                    color = YankeesBlue,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .padding(top = 4.dp)
                )
                Text(
                    ": تم ارسال الطلب منذ", fontSize = 11.sp,
                    fontFamily = Alexandria,
                    color = GrayBodyTextColor,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .padding(top = 4.dp)
                )

             }
        }
    }
}
