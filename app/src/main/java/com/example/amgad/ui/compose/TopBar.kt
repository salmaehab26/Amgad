package com.example.amgad.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amgad.R
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.YankeesBlue

@Composable
fun TopBar(onNavigateBack: () -> Unit, title: String, showIcon: Boolean) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
    ) {
        if (showIcon) {
            Image(painterResource(id = R.drawable.ic_filter), contentDescription = "filter")
        } else
            Spacer(modifier = Modifier.width(20.dp))
        Text(
            text = title,
            color = YankeesBlue,
            fontSize = 16.sp,
            fontFamily = Alexandria,
        )

        Image(
            painterResource(id = R.drawable.ic_back),
            contentDescription = "back",
            modifier = Modifier.clickable(onClick = onNavigateBack)
        )
    }
}
