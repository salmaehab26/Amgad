package com.example.amgad.ui.compose.Attendencescreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.YankeesBlue


@Composable
fun TopHeaderSection(onNavigateBack: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth().height(45.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            "سجل الحضور والتغيب",
            fontSize = 16.sp,
            color = YankeesBlue,
            textAlign = TextAlign.Center,
            fontFamily = Alexandria
        )
        Spacer(modifier = Modifier.width(90.dp))
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "Back",
            tint = YankeesBlue,
            modifier = Modifier
                .size(24.dp)
                .clickable(onClick = onNavigateBack)
        )
    }
}
