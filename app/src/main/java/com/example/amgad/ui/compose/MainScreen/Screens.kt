//package com.example.amgad.ui.compose.MainScreen
//
//import kotlinx.serialization.Serializable
//
//sealed interface Screens{
//    @Serializable
//    data object HomeScreen: Screens
//    @Serializable
//    data object ProfileScreen: Screens
//    @Serializable
//    data object AttendanceScreen: Screens
//    @Serializable
//    data object DocumentAttachmentScreen: Screens
//    @Serializable
//    data object HrRequestScreen: Screens
//    @Serializable
//    data class HrRequestDetailsScreen(
//        val requestId: String,
//        val name: String,
//        val time: String,
//        val typeTitle: String,
//        val statusName: String,
//        val TitleColor: Long,
//        val backgroundColor: Long,
//        val borderColor: Long
//    ) : Screens
//
//    @Serializable
//    data object Tab2: Screens
//    @Serializable
//    data object Tab3: Screens
//    @Serializable
//    data object Tab4: Screens
//    @Serializable
//    data object Tab5: Screens
//    @Serializable
//    data object MyLibraryScreen: Screens
//    @Serializable
//    data class MediaPlayerScreen(
//        val title: String,
//        val description: String?,
//        val mediaUrl: Int,
//        val mediaType: String
//    ) : Screens
//
//}