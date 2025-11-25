package com.example.amgad.ui.navigation

import HomeScreen
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.toRoute
import com.example.amgad.domain.model.MyLibraryModel.ItemType
import com.example.amgad.ui.compose.HrRequestScreen.HRRequestScreen
import com.example.amgad.ui.compose.MainScreen.Screen
import com.example.amgad.ui.compose.MyLibraryScreen.MediaPlayerScreen
import com.example.amgad.ui.compose.MyLibraryScreen.MyLibraryScreen
import com.example.amgad.ui.compose.OrderDetailsScreen
import com.example.amgad.ui.compose.ProfileScreen.ProfileSettingsScreen
import com.example.attendance.AttendanceScreen
import com.example.documentattachment.DocumentAttachmentScreen

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.homeGraph(
    navController: NavHostController,
    onShowSheet: () -> Unit,
    onShowDialog: () -> Unit
) {
    navigation<HomeGraph>(
        startDestination = HomeScreen
    ) {

        composable<HomeScreen> {
            HomeScreen(
                onCardClick = onShowSheet,
                onPersonalityClick = onShowDialog,
                navigatProfile = {
                    navController.navigate(ProfileScreen)
                },
                navigatAttendence = {
                    navController.navigate(AttendanceScreen)
                },
                navigatHrRequest = {
                    navController.navigate(HrRequestScreen)
                },
                navigatDocumentAtachement = {
                    navController.navigate(DocumentAttachmentScreen)
                },
                navigatMyLibrary = {
                    navController.navigate(MyLibraryScreen)
                }
            )
        }
        composable<Tab2>  { Screen("Tab 2") }
        composable<Tab3> { Screen("Tab 3") }
        composable<Tab4> { Screen("Tab 4") }
        composable<Tab5> { Screen("Tab 5") }





    }
}


fun NavGraphBuilder.profileGraph(navController: NavController) {
    navigation<ProfileGraph>(startDestination = ProfileScreen) {
        composable<ProfileScreen> {
            ProfileSettingsScreen {

                navController.popBackStack()
            }
        }
    }
}

fun NavGraphBuilder.myLibraryGraph(navController: NavController) {
    navigation<MyLibraryGraph>(startDestination = MyLibraryScreen) {
        composable<MyLibraryScreen> {
            MyLibraryScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToMediaPlayer = { item ->
                    navController.navigate(
                        MediaPlayerScreen(
                            title = item.title,
                            description = item.description,
                            mediaUrl = item.videoUrl,
                            mediaType = when (item.type) {
                                ItemType.Video -> "video"
                                ItemType.Audio -> "audio"
                                ItemType.Article -> "article"
                            }
                        )
                    )
                }
            )
        }

        composable<MediaPlayerScreen> {
            MediaPlayerScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}

fun NavGraphBuilder.hrRequestGraph(navController: NavController) {
    navigation<HrRequestGraph>(startDestination = HrRequestScreen) {
        composable<HrRequestScreen> {
            HRRequestScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToDetails = { item ->
                    navController.navigate(
                        HrRequestDetailsScreen(
                            requestId = item.id,
                            name = item.name,
                            time = item.time,
                            typeTitle = item.type.title,
                            statusName = item.status.name,
                            TitleColor = item.type.titleColor,
                            backgroundColor = item.type.backgroundColor,
                            borderColor = item.type.borderColor
                        )
                    )
                }
            )
        }

        composable<HrRequestDetailsScreen> {
            OrderDetailsScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}

fun NavGraphBuilder.uploadDocumentGraph(navController: NavController) {
    navigation<DocumentAttachmentGraph>(startDestination = DocumentAttachmentScreen) {
        composable<DocumentAttachmentScreen> {
            DocumentAttachmentScreen { navController.popBackStack() }
        }    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.attendanceGraph(navController: NavController) {
    navigation<AttendanceGraph>(startDestination = AttendanceScreen) {
        composable<AttendanceScreen> {
            AttendanceScreen { navController.popBackStack() }
        }

    }
}
