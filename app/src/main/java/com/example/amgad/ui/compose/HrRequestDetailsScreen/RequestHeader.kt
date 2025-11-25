package com.example.amgad.ui.compose.HrRequestDetailsScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amgad.R
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.YankeesBlue

@Composable
fun OrderHeader(onNavigateBack: () -> Unit) {
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
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.width(120.dp))
        Image(
            painter = painterResource(R.drawable.ic_back),
            contentDescription = "رجوع",
            modifier = Modifier
                .height(24.dp)
                .width(14.dp)
                .clickable(onClick = onNavigateBack)
        )
    }
}
