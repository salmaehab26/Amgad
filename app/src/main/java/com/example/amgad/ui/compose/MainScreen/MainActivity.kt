package com.example.amgad.ui.compose.MainScreen

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
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
    var openDialog by remember { mutableStateOf(false) }

    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()

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
            bottomBar = { BottomNavigationBar(navController) }) { innerPadding ->

            NavHost(
                navController = navController,
                startDestination =Screens.HomeScreen,
                modifier = Modifier.padding(innerPadding)
            ) {

                composable<Screens.HomeScreen> {
                    HomeScreen(
                        onCardClick = {
                            scope.launch { sheetState.show() }
                        }, onPersonalityClick = { openDialog = true },
                        navigatProfile = {
                            navController.navigate(Screens.ProfileScreen)
                        }, navigatAttendence = {
                            navController.navigate(Screens.AttendanceScreen)
                        }, navigatHrRequest = {
                            navController.navigate(Screens.HrRequestScreen)
                        }, navigatDocumentAtachement = {
                            navController.navigate(Screens.DocumentAttachmentScreen)
                        }, navigatMyLibrary = {
                            navController.navigate(Screens.MyLibraryScreen)
                        })
                }
                composable<Screens.Tab2> { Screen("screen 2") }
                composable<Screens.Tab3> { Screen("screen 3") }
                composable<Screens.Tab4> { Screen("screen 4") }
                composable<Screens.Tab5> { Screen("screen 5") }

                composable<Screens.ProfileScreen> { ProfileSettingsScreen(onNavigateBack={navController.popBackStack()}) }
                composable<Screens.AttendanceScreen> { AttendanceScreen(onNavigateBack={navController.popBackStack()}) }
                composable<Screens.DocumentAttachmentScreen>{ DocumentAttachmentScreen(onNavigateBack={navController.popBackStack()}) }
                composable<Screens.HrRequestScreen> {
                    HRRequestScreen(
                        onNavigateBack = { navController.popBackStack() },
                        onNavigateToDetails = { item ->
                            navController.navigate(
                                Screens.HrRequestDetailsScreen(
                                    requestId = item.id,
                                    name = item.name,
                                    time = item.time,
                                    typeTitle = item.type.title,
                                    statusName = item.status.name,
                                    TitleColor = item.type.titleColor,
                                    backgroundColor = item.type.backgroundColor,
                                    borderColor = item.type.borderColor,

                                    )
                            )
                        }
                    )
                }
                composable<Screens.HrRequestDetailsScreen> { backStackEntry ->
                    val args = backStackEntry.toRoute<Screens.HrRequestDetailsScreen>()
                    OrderDetailsScreen(
                        name = args.name,
                        time = args.time,
                        typeTitle = args.typeTitle,
                        statusName = args.statusName,
                        TitleColor=args.TitleColor,
                        backgroundColor=args.backgroundColor,
                        borderColor=args.borderColor,
                        onNavigateBack = { navController.popBackStack() }
                    )
                }
                composable<Screens.MyLibraryScreen> {
                    MyLibraryScreen(
                        onNavigateBack = { navController.popBackStack() },
                        onNavigateToMediaPlayer = { item ->
                            navController.navigate(
                                Screens.MediaPlayerScreen(
                                    title = item.title,
                                    description = item.description,
                                    mediaUrl = item.videoUrl ,
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

                composable<Screens.MediaPlayerScreen> { backStackEntry ->
                    val args = backStackEntry.toRoute<Screens.MediaPlayerScreen>()
                    MediaPlayerScreen(
                        title = args.title,
                        description = args.description,
                        mediaUrl = args.mediaUrl,
                        mediaType = args.mediaType,
                        onNavigateBack = { navController.popBackStack() }
                    )
                }
            }
            PersonalityDialog(
                openDialog = openDialog,
                onDismiss = { openDialog = false }
            )
        }
    }
}


@Composable
fun HomeScreen(
    onCardClick: () -> Unit,
    onPersonalityClick: () -> Unit,
    navigatProfile: () -> Unit,
    navigatAttendence: () -> Unit,
    navigatHrRequest: () -> Unit,
    navigatMyLibrary: () -> Unit,
    navigatDocumentAtachement: () -> Unit
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier.verticalScroll(scrollState)

    ) {
        TopAppbar(navigatProfile, navigatAttendence)
        ImageSliderCard()
        HrCard(navigatHrRequest)
        HrRequestCard()
        AmjadConsultantCard(onClick = onCardClick)
        PersonlityTest(onClick = onPersonalityClick)
        AssessmentCard()
        SurveysTabs()
        OffersCategoryPart(
            navigatMyLibrary =navigatMyLibrary
        )
        MostUsedOffersPart(navigatDocumentAtachement=navigatDocumentAtachement)

    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val bottomTabRoutes = listOf(
        Screens.HomeScreen,
        Screens.Tab2,
        Screens.Tab3,
        Screens.Tab4,
        Screens.Tab5
    )
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(Color.White),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.Top
        ) {
            bottomTabs.forEachIndexed { index, tab ->
                val tabRoute = bottomTabRoutes.getOrNull(index)
                val selected = currentDestination?.route == tabRoute?.let { it::class.qualifiedName }
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
                                    popUpTo(Screens.HomeScreen) {
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
                        painter = painterResource(id = if (selected) tab.selectedIcon else tab.unSelectedIcon),
                        contentDescription = tab.route,
                        modifier = Modifier.size(28.dp),

                        )

                }
            }
        }
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
    openDialog: Boolean,
    onDismiss: () -> Unit

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
sealed interface Screens{
    @Serializable
    data object HomeScreen: Screens
    @Serializable
    data object ProfileScreen: Screens
    @Serializable
    data object AttendanceScreen: Screens
    @Serializable
    data object DocumentAttachmentScreen: Screens
    @Serializable
    data object HrRequestScreen: Screens
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
    ) : Screens

    @Serializable
    data object Tab2: Screens
    @Serializable
    data object Tab3: Screens
    @Serializable
    data object Tab4: Screens
    @Serializable
    data object Tab5: Screens
    @Serializable
    data object MyLibraryScreen: Screens
    @Serializable
    data class MediaPlayerScreen(
        val title: String,
        val description: String?,
        val mediaUrl: Int?,
        val mediaType: String // "video", "audio", "article"
    ) : Screens

}


