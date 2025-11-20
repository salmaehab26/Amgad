import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amgad.R
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.ProfileBoxBannerBackground
import com.example.amgad.ui.theme.ProfileBoxBannerBorder
import com.example.amgad.ui.theme.ProfileBoxBannerText
import com.example.amgad.ui.theme.YankeesBlue

@Composable
fun MoodTrackerCard() {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .height(165.dp),
        colors = CardDefaults.cardColors(containerColor = ProfileBoxBannerBackground),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(
            color = ProfileBoxBannerBorder, width = 1.dp

        )
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(165.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.emoji_left_top_corner_illu__1_),
                    contentDescription = "emoji"
                )
                Spacer(modifier = Modifier.width(90.dp))

                Text(
                    text = "ما هو شعورك اليوم؟",
                    fontSize = 14.sp,
                    color = YankeesBlue,
                    fontFamily = Alexandria, modifier = Modifier.padding(top = 14.dp)
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Box(contentAlignment = Alignment.BottomEnd){
                Image(painter = painterResource(id=R.drawable.emoji_right_bottom_corner_illu__1_), contentDescription = "emoji")
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    horizontalArrangement = Arrangement.Center,
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
                                .width(52.dp)
                                .height(60.dp)
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
                                color = ProfileBoxBannerText,
                                modifier = Modifier.padding(bottom = 10.dp)
                            )
                        }
                    }
                }

            }
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
