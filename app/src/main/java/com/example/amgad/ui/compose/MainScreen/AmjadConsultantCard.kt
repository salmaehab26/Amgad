package com.example.amgad.ui.compose.MainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.amgad.R

@Composable
fun AmjadConsultantCard(onClick: () -> Unit) {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .height(155.dp)
            .clickable { onClick() },

        painter = painterResource(id = R.drawable.amjad_consultant_card),
        contentDescription = null,

        )

}