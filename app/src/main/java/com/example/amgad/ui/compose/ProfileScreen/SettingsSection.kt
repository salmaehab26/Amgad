package com.example.amgad.ui.compose.ProfileScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amgad.R
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.YankeesBlue

@Composable
fun SettingsSection() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.End
    ) {
        Text(
            text = "حسابي الشخصى",
            fontFamily = Alexandria,
            fontSize = 14.sp,
            color = YankeesBlue,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = White),
            shape = RoundedCornerShape(10.dp)
        ) {
            ItemSettings("البيانات الاساسية", R.drawable.ic_settings_profile)
            ItemSettings("فئات العروض المفضلة", R.drawable.ic_offer_preferences_profile)
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "النقاط و العروض المستفاد منها",
            fontFamily = Alexandria,
            fontSize = 14.sp,
            color = YankeesBlue,
            modifier = Modifier.padding(bottom = 15.dp)
        )
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = White),
            shape = RoundedCornerShape(10.dp)
        ) {
            ItemSettings("العروض المستفاد منها", R.drawable.ic_redeemed_offers_profile)
        }
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "المفضلة",
            fontFamily = Alexandria,
            fontSize = 14.sp,
            color = YankeesBlue,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = White),
            shape = RoundedCornerShape(10.dp)
        ) {
            ItemSettings("العروض المفضلة", R.drawable.ic_offers_profile)
            ItemSettings("المتاجر المفضلة", R.drawable.ic_vendors_profile)
        }
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "أفراد العائلة",
            fontFamily = Alexandria,
            fontSize = 14.sp,
            color = YankeesBlue,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = White),
            shape = RoundedCornerShape(10.dp)
        ) { ItemSettings("أفراد العائلة", R.drawable.ic_family_members_profile) }
        Spacer(modifier = Modifier.height(30.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = White),
            shape = RoundedCornerShape(10.dp)
        ) { ItemSettings("الدعم الفني", R.drawable.ic_support_tickets) }
        Spacer(modifier = Modifier.height(30.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = White),
            shape = RoundedCornerShape(10.dp)
        ) { ItemSettings("الإعدادات", R.drawable.ic_settings) }
        Spacer(modifier = Modifier.height(30.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = White),
            shape = RoundedCornerShape(10.dp)
        ) { ItemSettings("تسجيل خروج", R.drawable.ic_logout_profile, false) }
    }
}
