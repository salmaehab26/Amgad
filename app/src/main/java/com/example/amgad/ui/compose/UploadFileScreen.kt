package com.example.documentattachment

import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amgad.R
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.AssessmentCardGrayText
import com.example.amgad.ui.theme.CompanyColor
import com.example.amgad.ui.theme.GrayBodyTextColor
import com.example.amgad.ui.theme.TextFieldFilled
import com.example.amgad.ui.theme.UploadAttachmentButton
import com.example.amgad.ui.theme.UploadAttachmentCardText
import com.example.amgad.ui.theme.UploadCardBackground
import com.example.amgad.ui.theme.UploadCardBorder
import com.example.amgad.ui.theme.UploadCardText
import com.example.amgad.ui.theme.YankeesBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DocumentAttachmentScreen(onNavigateBack: () -> Unit) {
    var noteText by remember { mutableStateOf("") }
    var selectedFileName by remember { mutableStateOf<String?>(null) }
    var selectedFileSize by remember { mutableStateOf<String?>(null) }
    val maxChars = 500

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.End
    ) {
        Row (modifier = Modifier.padding(bottom = 20.dp).height(45.dp) ){
            Text(
                text = "إرفاق الوثيقة المطلوبة",
                textAlign = TextAlign.Center,
                fontFamily = Alexandria,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.width(85.dp))
            Image(
               painter = painterResource(id=R.drawable.ic_close_black) ,
                contentDescription = "Close",
                Modifier.size(24.dp).clickable(onClick = onNavigateBack))


        }
        Text(
            text = "الوثيقة المطلوبة",
            fontSize = 16.sp,
            fontFamily = Alexandria,
            color = YankeesBlue,
            fontWeight = FontWeight.Bold, textAlign = TextAlign.End,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
        )
        val context = LocalContext.current

        val filePickerLauncher =
            rememberLauncherForActivityResult(
                contract = ActivityResultContracts.OpenDocument()
            ) { uri ->
                uri?.let {
                    val name = getFileName(context, uri)
                    val sizeInBytes = getFileSize(context, uri)
                    val sizeInMB = sizeInBytes / (1024 * 1024f)

                    if (sizeInMB > 5f) {
                        Toast.makeText(context, "الملف أكبر من 5 ميجا!", Toast.LENGTH_SHORT).show()
                        return@let
                    }

                    selectedFileName = name
                    selectedFileSize = String.format("%.2f MB", sizeInMB)
                }
            }
        Box(

            modifier = Modifier
                .width(380.dp)
                .height(150.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(White)
                .clickable {
                    filePickerLauncher.launch(
                        arrayOf(
                            "application/pdf",
                            "image/jpeg",
                            "image/png"
                        )
                    )
                }

                .drawBehind {
                    val strokeWidth = 3.dp.toPx()
                    val dashWidth = 5.dp.toPx()
                    val dashGap = 6.dp.toPx()

                    drawRoundRect(
                        color = Color(0xFFE0E0E0),
                        size = size,
                        cornerRadius = CornerRadius(10.dp.toPx()),
                        style = Stroke(
                            width = strokeWidth, pathEffect = PathEffect.dashPathEffect(
                                floatArrayOf(dashWidth, dashGap), 0f
                            )
                        )
                    )
                }, contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.upload_file_ic),
                    contentDescription = "Upload", Modifier.size(25.dp)
                )

                Text(
                    text = "تحميل/ اختيار الملف",
                    color = CompanyColor,
                    fontSize = 14.sp,
                    fontFamily = Alexandria,
                )
                Row {
                    Text(
                        text = "PDF, JPG or PNG",
                        color = UploadAttachmentCardText,
                        fontSize = 12.sp, fontFamily = Alexandria,

                        )
                    Text(
                        text = " :الملفات المدعومة",
                        color = AssessmentCardGrayText,
                        fontSize = 11.sp, fontFamily = Alexandria
                    )
                }

                Row {

                    Text(
                        text = "ميجا ",
                        color = UploadAttachmentCardText,
                        fontSize = 12.sp, fontFamily = Alexandria
                    )
                    Text(
                        text = "5",
                        color = UploadAttachmentCardText,
                        fontSize = 12.sp, fontFamily = Alexandria
                    )
                    Text(
                        text = " :الحجم الأقصى للملف",
                        color = AssessmentCardGrayText,
                        fontSize = 12.sp, fontFamily = Alexandria
                    )

                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (selectedFileName != null && selectedFileSize != null) {
            FileContainer(
                fileName = selectedFileName!!,
                fileSize = selectedFileSize!!,
                onDelete = {
                    selectedFileName = null
                    selectedFileSize = null
                }
            )
        }


        Spacer(modifier = Modifier.height(16.dp))




        Column {

            TextField(
                value = noteText,
                onValueChange = {
                    if (it.length <= maxChars) {
                        noteText = it
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .background(TextFieldFilled, RoundedCornerShape(6.dp)),
                placeholder = {
                    Text(
                        text = "...اكتب ملاحظاتك هنا",
                        color = GrayBodyTextColor,
                        fontSize = 18.sp,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.End,
                        fontFamily = Alexandria
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Transparent,
                    unfocusedContainerColor = TextFieldFilled,
                    focusedContainerColor = TextFieldFilled
                ),
                textStyle = LocalTextStyle.current.copy(
                    textAlign = TextAlign.End,
                    color = GrayBodyTextColor
                ),
                shape = RoundedCornerShape(8.dp),

                )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "${noteText.length}/$maxChars",
                    fontSize = 13.sp,
                    fontFamily = Alexandria,
                    color = GrayBodyTextColor,
                )
                Text(
                    text = "اختيارى",
                    fontSize = 13.sp,
                    color = GrayBodyTextColor,
                    fontFamily = Alexandria,

                    )
            }

        }

        Spacer(modifier = Modifier.weight(1f))

        // Submit button
        Button(
            onClick = { /* Handle submit */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = UploadAttachmentButton
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "إرفاق الوثيقة",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = Alexandria,
            )
        }
    }
}


//@Composable
//fun DocumentAttachmentApp() {
//    MaterialTheme {
//        DocumentAttachmentScreen()
//    }
//}

@Composable
fun FileContainer(
    fileName: String,
    fileSize: String,
    onDelete: () -> Unit
) {

    val fileExtension = getFileExtension(fileName)

    val fileIcon = when (fileExtension) {
        "pdf" -> R.drawable.pdf
        "jpg", "jpeg", "png" -> R.drawable.photo_gallery
        else -> R.drawable.ic_close
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(color = UploadCardBackground)
            .border(
                color = UploadCardBorder,
                width = 1.dp,
                shape = RoundedCornerShape(6.dp)

            ),
        Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_delete__1_),
                contentDescription = "Delete",
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onDelete() }
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column(modifier = Modifier.width(270.dp), horizontalAlignment = Alignment.End) {
                Text(
                    text = fileName,
                    fontSize = 14.sp,
                    color = YankeesBlue, fontFamily = Alexandria

                )
                Text(
                    text = fileSize,
                    fontSize = 14.sp,
                    color = UploadCardText, fontFamily = Alexandria
                )

            }
            Spacer(modifier = Modifier.width(15.dp))

            Image(
                painter = painterResource(fileIcon),
                contentDescription = "pdf",

                modifier = Modifier.size(24.dp)
            )

        }
    }
}

fun getFileName(context: Context, uri: Uri): String {
    var name = "File"
    val cursor = context.contentResolver.query(uri, null, null, null, null)
    cursor?.use {
        if (it.moveToFirst()) {
            name = it.getString(it.getColumnIndexOrThrow(OpenableColumns.DISPLAY_NAME))
        }
    }
    return name
}

fun getFileSize(context: Context, uri: Uri): Long {
    val cursor = context.contentResolver.query(uri, null, null, null, null)
    var size = 0L
    cursor?.use {
        if (it.moveToFirst()) {
            size = it.getLong(it.getColumnIndexOrThrow(OpenableColumns.SIZE))
        }
    }
    return size
}

fun getFileExtension(fileName: String): String {
    return fileName.substringAfterLast('.', "").lowercase()
}