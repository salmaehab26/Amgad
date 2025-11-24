package com.example.amgad.ui.compose

import androidx.annotation.OptIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import com.example.amgad.R
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.YankeesBlue
import androidx.core.net.toUri
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.media3.common.util.Log
import com.example.amgad.ui.theme.AudiioScreenBackground
import com.example.amgad.ui.theme.Gray
import com.example.amgad.ui.theme.GrayBodyTextColor
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive

@OptIn(UnstableApi::class)
@Composable
fun MediaPlayerScreen(
    title: String,
    description: String?,
    mediaUrl: Int?,
    mediaType: String,
    onNavigateBack: () -> Unit
) {
    val context = LocalContext.current

    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            val uri = "android.resource://${context.packageName}/$mediaUrl".toUri()
            val mediaItem = MediaItem.fromUri(uri)
            setMediaItem(mediaItem)
            prepare()
            playWhenReady = true
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                if (mediaType == "article") White else Color.Black
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    if (mediaType == "article") White else Color.Black
                )
                .padding(16.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.ic_back),
                contentDescription = "رجوع",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onNavigateBack() })

            Spacer(Modifier.width(16.dp))

            Text(
                text = title,
                fontSize = 16.sp,
                fontFamily = Alexandria,
                color = if (mediaType == "article") YankeesBlue else White,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.End
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(
                    when (mediaType) {
                        "article" -> White
                        else -> Color(0xFF1A1A1A)
                    }
                ), contentAlignment = Alignment.Center
        ) {
            when (mediaType) {
                "video" -> {
                    AndroidView(
                        factory = { context ->
                            PlayerView(context).apply {
                                player = exoPlayer
                                useController = true
                            }
                        }, modifier = Modifier.fillMaxSize()
                    )
                }

                "audio" -> {
                    mediaUrl?.let { url ->
                        AudioPlayerCard(
                            title = title, onBack = onNavigateBack,exoPlayer=exoPlayer
                        )
                    }
                }


                "article" -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(White)
                            .padding(16.dp)
                    ) {
                        Spacer(Modifier.height(16.dp))

                        description?.let {
                            Text(
                                text = it,
                                fontSize = 16.sp,
                                fontFamily = Alexandria,
                                color = Color.Black,
                                textAlign = TextAlign.End,
                                lineHeight = 28.sp
                            )
                        }
                    }
                }
            }
        }
    }
}

@OptIn(UnstableApi::class)
@Composable
fun AudioPlayerCard(
    title: String, onBack: () -> Unit,exoPlayer: ExoPlayer
) {


    var isPlaying by remember { mutableStateOf(false) }
    var position by remember { mutableStateOf(0L) }
    var duration by remember { mutableStateOf(0L) }


    LaunchedEffect(exoPlayer) {
        while (isActive) {
            position = exoPlayer.currentPosition
            duration = exoPlayer.duration.takeIf { it > 0 } ?: 0L
            delay(500)
        }
    }

    fun formatTime(ms: Long): String {
        val totalSeconds = ms / 1000
        val minutes = totalSeconds / 60
        val seconds = totalSeconds % 60
        return "%02d:%02d".format(minutes, seconds)
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AudiioScreenBackground)
            .padding(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .width(320.dp)
                .height(123.dp)
                .background(White, RoundedCornerShape(16.dp))
                .padding(16.dp),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                title,
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                color = YankeesBlue,
                fontFamily = Alexandria
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .width(285.dp)
                    .height(30.dp)
                    .background(AudiioScreenBackground, shape = RoundedCornerShape(7.dp))

            ) {
                Box(
                    modifier = Modifier
                        .padding(9.dp)
                        .size(20.dp)
                        .clickable {    exoPlayer.playWhenReady = !exoPlayer.playWhenReady },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(
                            if (isPlaying) R.drawable.pause else R.drawable.play_buttton
                        ),
                        contentDescription = if (isPlaying) "Pause" else "Play",
                        modifier = Modifier.size(15.dp)
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                Slider(
                    value = if (duration > 0) position / duration.toFloat() else 0f,
                    onValueChange = {
                    newValue ->
                        val seekPosition = (newValue * duration).toLong()
                        exoPlayer.seekTo(seekPosition)
                    },
                    modifier = Modifier
                        .width(144.dp)
                        .height(5.dp), colors = SliderColors(
                        thumbColor = White,
                        disabledThumbColor = White,
                        disabledInactiveTrackColor = White,
                        activeTrackColor = White,
                        activeTickColor = White,
                        inactiveTrackColor = White,
                        inactiveTickColor = White,
                        disabledActiveTrackColor = White,
                        disabledActiveTickColor = White,
                        disabledInactiveTickColor = White,
                    )
                )


                Text(
                    text = if (duration > 0) formatTime(duration - position) else "--:--",
                    fontSize = 14.sp,
                    color = White,
                    modifier = Modifier.width(50.dp),
                    textAlign = TextAlign.End
                )
            }
        }
    }
}