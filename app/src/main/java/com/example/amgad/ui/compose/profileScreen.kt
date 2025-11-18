package com.example.amgad.ui.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.amgad.ui.compose.MainScreen.PersonalityDialog
import com.example.amgad.ui.compose.MainScreen.PersonlityTest
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.CompanyColor
import com.example.amgad.ui.theme.GrayBodyTextColor
import com.example.amgad.ui.theme.LogOutRed
import com.example.amgad.ui.theme.ProfileBoxBannerBackground
import com.example.amgad.ui.theme.ProfileBoxBannerBorder
import com.example.amgad.ui.theme.ProfileBoxBannerText
import com.example.amgad.ui.theme.ProfileBoxLocationBackground
import com.example.amgad.ui.theme.SettingsIconBackground
import com.example.amgad.ui.theme.YankeesBlue

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileSettingsScreen() {
    var openDialog by remember { mutableStateOf(false) }


        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())) {
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
                    Modifier.size(30.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            ProfileHeader()

            Spacer(modifier = Modifier.height(16.dp))

            MoodTrackerCard()

            Spacer(modifier = Modifier.height(16.dp))

            PersonlityTest(onClick = { openDialog = true })

            Spacer(modifier = Modifier.height(16.dp))

            // Settings Section
            SettingsSection()

            Spacer(modifier = Modifier.height(16.dp))

            LogoutButton()

            Spacer(modifier = Modifier.height(24.dp))
        }
    PersonalityDialog(
        openDialog = openDialog, onDismiss = { openDialog = false })
    }


@Composable
fun ProfileHeader() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(containerColor =  Color.Transparent),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFE8E8E8)), contentAlignment = Alignment.Center
            ) {
                Text(text = "م", fontSize = 26.sp, fontFamily = Alexandria, color = YankeesBlue)
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
                    .background(White),
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


        }
    }
}

@Composable
fun MoodTrackerCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(165.dp)
            .padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(containerColor = ProfileBoxBannerBackground),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(
            color = ProfileBoxBannerBorder, width = 1.dp

        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(165.dp)
                .padding(top = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "ما هو شعورك اليوم؟",
                fontSize = 14.sp,
                color = YankeesBlue,
                fontFamily = Alexandria
            )

            Spacer(modifier = Modifier.height(25.dp))

            // Mood Emojis
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                listOf(
                    R.drawable.emoji_anxious to "قلق",
                    R.drawable.emoji_angry to "غضب",
                    R.drawable.emoji_exhausted to "إرهاق",
                    R.drawable.emoji_sad to "حزن",
                    R.drawable.emoji_enthusiastic to "حماس",
                    R.drawable.emoji_happy to "سعادة"
                ).forEach { (emoji, name) ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .width(50.dp)
                            .height(50.dp)
                    ) {
                        Image(
                            painter = painterResource(id = emoji),
                            contentDescription = "emoji",
                            modifier = Modifier.size(32.dp)
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = name,
                            fontSize = 8.sp,
                            fontFamily = Alexandria,
                            color = ProfileBoxBannerText
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
                    .background(ProfileBoxBannerBorder),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    Icons.Default.KeyboardArrowLeft,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                    tint = Color(0xFF2C2C2C)
                )
                Spacer(modifier = Modifier.width(8.dp))


                Text(
                    text = "تاريخ مشاعرك",
                    color = ProfileBoxBannerText,
                    fontSize = 14.sp,
                    fontFamily = Alexandria
                )
                Spacer(modifier = Modifier.width(8.dp))

                Image(
                    painter = painterResource(id = R.drawable.ic_history),
                    contentDescription = null,
                )

            }
        }
    }
}


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
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = White),
            shape = RoundedCornerShape(10.dp)
        ) {
            Item("البيانات الاساسية", R.drawable.ic_settings_profile)
            Item("فئات العروض المفضلة", R.drawable.ic_offer_preferences_profile)
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
            Item("العروض المستفاد منها", R.drawable.ic_redeemed_offers_profile)
        }
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "المفضلة",
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
            Item("العروض المفضلة", R.drawable.ic_offers_profile)
            Item("المتاجر المفضلة", R.drawable.ic_vendors_profile)
        }
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "المفضلة",
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
        ) {  Item("أفراد العائلة", R.drawable.ic_family_members_profile)}
        Spacer(modifier = Modifier.height(30.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = White),
            shape = RoundedCornerShape(10.dp)
        ) {  Item("الدعم الفني", R.drawable.ic_support_tickets)}
        Spacer(modifier = Modifier.height(30.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = White),
            shape = RoundedCornerShape(10.dp)
        ) {  Item("الإعدادات", R.drawable.ic_settings)}
        Spacer(modifier = Modifier.height(30.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = White),
            shape = RoundedCornerShape(10.dp)
        ) {  Item("تسجيل خروج", R.drawable.ic_logout_profile,false)}
    }
}


@Composable
fun Item(title: String, image: Int, showArrow: Boolean = true) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(horizontal = 16.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween) {
        if (showArrow) {
            Icon(
                Icons.Default.KeyboardArrowLeft,
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        } else {
            Spacer(modifier = Modifier.width(20.dp))
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = title,
                fontSize = 14.sp, fontFamily = Alexandria,
                color = YankeesBlue,

                )

            Spacer(modifier = Modifier.width(8.dp))

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        color = SettingsIconBackground, shape = RoundedCornerShape(10.dp)
                    ),
                contentAlignment = Alignment.Center,
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )

            }
        }


    }

}

@Composable
fun LogoutButton() {
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = LogOutRed
        ),
        shape = RoundedCornerShape(6.dp)
    ) {
        Text(
            text = "تقديم طلب استقالة", fontSize = 18.sp,  fontFamily = Alexandria
        )
    }
}