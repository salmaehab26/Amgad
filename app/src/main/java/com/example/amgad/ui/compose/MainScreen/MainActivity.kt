package com.example.amgad.ui.compose.MainScreen

import HomeScreen
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.navigation.toRoute
import com.example.amgad.domain.model.MyLibraryModel.ItemType
import com.example.amgad.ui.compose.HrRequestScreen.HRRequestScreen
import com.example.amgad.ui.compose.MediaPlayerScreen
import com.example.amgad.ui.compose.MyLibraryScreen.MyLibraryScreen
import com.example.amgad.ui.compose.OrderDetailsScreen
import com.example.amgad.ui.compose.ProfileScreen.ProfileSettingsScreen
import com.example.amgad.ui.navigation.AttendanceScreen
import com.example.amgad.ui.navigation.DocumentAttachmentScreen
import com.example.amgad.ui.navigation.HomeGraph
import com.example.amgad.ui.navigation.HomeScreen
import com.example.amgad.ui.navigation.HrRequestDetailsScreen
import com.example.amgad.ui.navigation.HrRequestScreen
import com.example.amgad.ui.navigation.MediaPlayerScreen
import com.example.amgad.ui.navigation.MyLibraryScreen
import com.example.amgad.ui.navigation.ProfileScreen
import com.example.amgad.ui.navigation.Tab2
import com.example.amgad.ui.navigation.Tab2Graph
import com.example.amgad.ui.navigation.Tab3
import com.example.amgad.ui.navigation.Tab3Graph
import com.example.amgad.ui.navigation.Tab4
import com.example.amgad.ui.navigation.Tab4Graph
import com.example.amgad.ui.navigation.Tab5
import com.example.amgad.ui.navigation.Tab5Graph
import com.example.attendance.AttendanceScreen
import com.example.documentattachment.DocumentAttachmentScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MainRoot()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainRoot() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    var openDialog by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()

    val routesWithBottomBar = setOf(
        HomeScreen::class.qualifiedName,
        Tab2::class.qualifiedName,
        Tab3::class.qualifiedName,
        Tab4::class.qualifiedName,
        Tab5::class.qualifiedName
    )

    val shouldShowBottomBar = currentDestination?.route in routesWithBottomBar

    Box(modifier = Modifier.fillMaxSize()) {
        ModalBottomSheetLayout(
            sheetState = sheetState,
            sheetContent = {
                BottomSheetScreen(onClose = {
                    scope.launch { sheetState.hide() }
                })
            },
            sheetBackgroundColor = Color.White,
            sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
        ) {
            Scaffold(

                bottomBar = {
                    if (shouldShowBottomBar) {
                        BottomNavigationBar(navController, modifier = Modifier.padding(
                            WindowInsets.navigationBars.asPaddingValues()
                        ))
                    }
                }
            ) { padding ->
              Box(Modifier
                  .padding(padding)){
                  NavHost(
                    navController = navController,
                    startDestination = HomeGraph,
                      modifier = Modifier.fillMaxSize()
                ) {
                    homeGraph(
                        navController = navController,
                        onShowSheet = { scope.launch { sheetState.show() } },
                        onShowDialog = { openDialog = true }
                    )
                    tab2Graph()
                    tab3Graph()
                    tab4Graph()
                    tab5Graph()
                }
            }
        }}

        if (openDialog) {
            PersonalityDialog(
                openDialog = openDialog,
                onDismiss = { openDialog = false }
            )
        }
    }
}

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

        composable<ProfileScreen> {
            ProfileSettingsScreen { navController.popBackStack() }
        }
        composable<AttendanceScreen> {
            AttendanceScreen { navController.popBackStack() }
        }
        composable<DocumentAttachmentScreen> {
            DocumentAttachmentScreen { navController.popBackStack() }
        }

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

        composable<HrRequestDetailsScreen> { entry ->
            val args = entry.toRoute<HrRequestDetailsScreen>()
            OrderDetailsScreen(
                name = args.name,
                time = args.time,
                typeTitle = args.typeTitle,
                statusName = args.statusName,
                TitleColor = args.TitleColor,
                backgroundColor = args.backgroundColor,
                borderColor = args.borderColor,
                onNavigateBack = { navController.popBackStack() }
            )
        }

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

        composable<MediaPlayerScreen> { entry ->
            val args = entry.toRoute<MediaPlayerScreen>()
            MediaPlayerScreen(
                title = args.title,
                description = args.description,
                mediaUrl = args.mediaUrl,
                mediaType = args.mediaType,
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}


fun NavGraphBuilder.tab2Graph() {
    navigation<Tab2Graph>(startDestination = Tab2) {
        composable<Tab2> { Screen("Tab 2") }
    }
}

fun NavGraphBuilder.tab3Graph() {
    navigation<Tab3Graph>(startDestination = Tab3) {
        composable<Tab3> { Screen("Tab 3") }
    }
}

fun NavGraphBuilder.tab4Graph() {
    navigation<Tab4Graph>(startDestination = Tab4) {
        composable<Tab4> { Screen("Tab 4") }
    }
}

fun NavGraphBuilder.tab5Graph() {
    navigation<Tab5Graph>(startDestination = Tab5) {
        composable<Tab5> { Screen("Tab 5") }
    }
}



