package com.example.amgad.ui.compose.ProfileScreen

import MoodTrackerCard
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import com.example.amgad.ui.compose.MainScreen.PersonalityDialog
import com.example.amgad.ui.compose.MainScreen.PersonlityTest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileSettingsScreen(onNavigateBack: () -> Unit) {
    var openDialog by remember { mutableStateOf(false) }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier
                .padding(end = 10.dp)
                .fillMaxWidth()
                .height(45.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Back",
                Modifier.size(30.dp).clickable(true, onClick = onNavigateBack)
            )
        }

        ProfileHeader()

        Spacer(modifier = Modifier.height(16.dp))

        MoodTrackerCard()

        Spacer(modifier = Modifier.height(16.dp))

        PersonlityTest(onClick = { openDialog = true })

        Spacer(modifier = Modifier.height(16.dp))

        SettingsSection()

        Spacer(modifier = Modifier.height(16.dp))

        LogoutButton()

        Spacer(modifier = Modifier.height(24.dp))
    }
    PersonalityDialog(
        openDialog = openDialog, onDismiss = { openDialog = false })
}






