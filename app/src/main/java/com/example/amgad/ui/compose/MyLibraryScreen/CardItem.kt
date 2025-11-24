package com.example.amgad.ui.compose.MyLibraryScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amgad.R
import com.example.amgad.domain.model.MyLibraryModel.ItemType
import com.example.amgad.domain.model.MyLibraryModel.MyLibraryModel
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.GrayBodyTextColor
import com.example.amgad.ui.theme.HrRequestTabBackground
import com.example.amgad.ui.theme.WhiteBackground
import com.example.amgad.ui.theme.YankeesBlue

@Composable
fun CardItem(
    item: MyLibraryModel,
    onCardClick: () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var needsExpand by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth().padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = onCardClick), elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ),
        colors = CardDefaults.cardColors(WhiteBackground),
    ) {
            Row(
                modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(top=18.dp, start = 16.dp,end=16.dp, bottom = 18.dp),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.End
            ) {

                if (item.type != ItemType.Article) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_play),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(end = 12.dp)
                            .size(28.dp)
                    )
                }

                Column(horizontalAlignment = Alignment.End) {

                    Text(
                        text = item.title,
                        fontSize = 14.sp,
                        fontFamily = Alexandria,
                        fontWeight = FontWeight.SemiBold,
                        color = YankeesBlue,
                        modifier = Modifier
                            .padding(end = 12.dp)
                            .width(248.dp),
                        textAlign = TextAlign.End
                    )

                    Spacer(Modifier.height(6.dp))

                    if (!item.description.isNullOrEmpty()) {

                        Text(
                            text = item.description!!,
                            fontSize = 11.sp,
                            fontFamily = Alexandria,
                            color = GrayBodyTextColor,
                            textAlign = TextAlign.End,
                            lineHeight = 16.sp,
                            maxLines = if (expanded) Int.MAX_VALUE else 2,
                            overflow = TextOverflow.Ellipsis,
                            onTextLayout = { textLayoutResult ->
                                if (!expanded) {
                                    needsExpand = textLayoutResult.hasVisualOverflow
                                }
                            },
                            modifier = Modifier
                                .padding(end = 12.dp)
                                .width(250.dp)
                        )
                        if (needsExpand) {
                            Row(
                                modifier = Modifier.width(250.dp),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Image(
                                    painter = painterResource(
                                        id = if (expanded) R.drawable.upload else R.drawable.down_arrow
                                    ),
                                    contentDescription = "Expand",
                                    modifier = Modifier
                                        .size(20.dp)
                                        .padding(top = 4.dp)
                                        .clickable { expanded = !expanded }
                                )
                            }
                        }
                    }
                }

                if (item.image == null) {
                    Box(
                        modifier = Modifier
                            .height(50.dp)
                            .width(50.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFFE6E6E6)),
                        contentAlignment = Alignment.Center
                    ) {
                        if (item.type == ItemType.Video) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_video),
                                contentDescription = null,
                                modifier = Modifier.size(20.dp)
                            )
                        } else if (item.type == ItemType.Audio) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_audio),
                                contentDescription = null,
                                modifier = Modifier.size(20.dp)
                            )
                        } else if (item.type == ItemType.Article) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_article),
                                contentDescription = null,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                } else {
                    Image(
                        painter = painterResource(id = item.image),
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .border(
                                color = HrRequestTabBackground,
                                width = 1.dp,
                                shape = RoundedCornerShape(10.dp)
                            )
                    )
                }
            }

    }
}