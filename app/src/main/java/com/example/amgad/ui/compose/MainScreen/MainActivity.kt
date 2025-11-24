package com.example.amgad.ui.compose.MainScreen

import HomeScreen
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.ScaffoldDefaults.contentWindowInsets
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
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
import com.example.amgad.ui.theme.CompanyColor
import com.example.app.ui.navigation.bottomTabs
import com.example.attendance.AttendanceScreen
import com.example.documentattachment.DocumentAttachmentScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

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

@Composable
fun BottomNavigationBar(navController: NavHostController,modifier: Modifier = Modifier ) {

    val bottomNavDestinations = listOf(
        HomeGraph, Tab2Graph, Tab3Graph, Tab4Graph, Tab5Graph
    )

    val entry by navController.currentBackStackEntryAsState()
    val currentDestination = entry?.destination

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.White),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.Top
        ) {

            bottomTabs.forEachIndexed { index, tab ->

                val tabRoute = bottomNavDestinations.getOrNull(index)

                val selected = when (tabRoute) {
                    HomeGraph -> currentDestination?.route == HomeScreen::class.qualifiedName
                    Tab2Graph -> currentDestination?.route == Tab2::class.qualifiedName
                    Tab3Graph -> currentDestination?.route == Tab3::class.qualifiedName
                    Tab4Graph -> currentDestination?.route == Tab4::class.qualifiedName
                    Tab5Graph -> currentDestination?.route == Tab5::class.qualifiedName
                    else -> false
                }

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(80.dp)
                        .background(
                            if (selected) CompanyColor.copy(alpha = 0.1f)
                            else Color.Transparent
                        )
                        .clickable {
                            tabRoute?.let {
                                navController.navigate(it) {
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {

                    Box(
                        modifier = Modifier
                            .height(3.dp)
                            .fillMaxWidth()
                            .clip(
                                RoundedCornerShape(
                                    bottomStart = 6.dp,
                                    bottomEnd = 6.dp,
                                    topStart = 0.dp,
                                    topEnd = 0.dp
                                )
                            )
                            .background(
                                if (selected) CompanyColor
                                else Color.Transparent
                            )
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Image(
                        painter = painterResource(
                            id = if (selected) tab.selectedIcon else tab.unSelectedIcon
                        ),
                        contentDescription = tab.route,
                        modifier = Modifier.size(28.dp)
                    )
                }
            }
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





@Composable
fun Screen(text: String) {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(text, color = Color.Black)
    }
}

@Composable
fun PersonalityDialog(
    openDialog: Boolean, onDismiss: () -> Unit

) {
    if (openDialog) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f)),
            contentAlignment = Alignment.Center
        ) {
            AlertDialogContent(onDismiss = onDismiss)
        }
    }
}


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
object Tab2Graph

@Serializable
object Tab3Graph

@Serializable
object Tab4Graph

@Serializable
object Tab5

@Serializable
object Tab5Graph

@Serializable
object MyLibraryScreen

@Serializable
object HomeGraph


@Serializable
data class MediaPlayerScreen(
    val title: String, val description: String?, val mediaUrl: Int?, val mediaType: String
)




