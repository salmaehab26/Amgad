package com.example.amgad.ui.navigation

import kotlinx.serialization.Serializable


@Serializable
object HomeScreen

@Serializable
object ProfileScreen

@Serializable
object AttendanceScreen

@Serializable
object DocumentAttachmentScreen

@Serializable
object HrRequestScreen

@Serializable
data class HrRequestDetailsScreen(
    val requestId: String,
    val name: String,
    val time: String,
    val typeTitle: String,
    val statusName: String,
    val TitleColor: Long,
    val backgroundColor: Long,
    val borderColor: Long
)

@Serializable
object Tab2

@Serializable
object Tab3

@Serializable
object Tab4

@Serializable
object Tab5

@Serializable
object ProfileGraph

@Serializable
object DocumentAttachmentGraph

@Serializable
object AttendanceGraph

@Serializable
object Tab4Graph

@Serializable
object HrRequestGraph

@Serializable
object MyLibraryGraph

@Serializable
object MyLibraryScreen

@Serializable
object HomeGraph


@Serializable
data class MediaPlayerScreen(
    val title: String, val description: String?, val mediaUrl: Int?, val mediaType: String
)