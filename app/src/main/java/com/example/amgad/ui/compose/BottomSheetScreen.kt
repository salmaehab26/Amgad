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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amgad.R
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.CompanyColor
import com.example.amgad.ui.theme.SheetHeader
import com.example.amgad.ui.theme.YankeesBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetScreen(onClose: () -> Unit) {

    val items = listOf(
        "أسرية" to R.drawable.consultation_family_ic,
        "دينية" to R.drawable.consultation_religious_ic,
        "رياضية" to R.drawable.consultation_sports_ic,
        "مالية" to R.drawable.consultation_financial_ic,
        "مجتمعية" to R.drawable.consultation_social_ic,
        "نفسية" to R.drawable.consultation_psychological_ic,
        "مهنية" to R.drawable.consultation_career_ic,
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .height(5.dp)
                    .width(36.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(color = SheetHeader)
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth().height(60.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(onClick = { onClose() }) {
                Icon(
                    painterResource(id = R.drawable.ic_close), contentDescription = "Close",
                )
            }
            Text("اختر نوع الاستشارة لبدء المحادثة",
                color = YankeesBlue,
                fontSize = 18.sp,
                fontFamily = Alexandria)

        }

        Spacer(modifier = Modifier.height(8.dp))

        Column(
            modifier = Modifier
                .height(470.dp)
                .verticalScroll(rememberScrollState())
        ) {
            items.forEach { (name, iconRes) ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth().height(64.dp)
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.End
                ) {
                    Text(name, fontFamily = Alexandria, color = YankeesBlue, fontSize = 16.sp)
                    Spacer(Modifier.width(12.dp))
                    Image(
                        painterResource(iconRes),
                        contentDescription = name,
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
        }
    }
}