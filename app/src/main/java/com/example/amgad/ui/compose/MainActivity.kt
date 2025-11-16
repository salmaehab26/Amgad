package com.example.amgad.ui.compose

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
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.amgad.R
import com.example.amgad.ui.theme.Alexandria
import com.example.amgad.ui.theme.CompanyColor
import com.example.amgad.ui.theme.YankeesBlue
import com.example.app.ui.navigation.bottomTabs
import com.example.attendance.AttendanceScreen
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
                startDestination = "home",
                modifier = Modifier.padding(innerPadding)
            ) {

                composable("home") {
                    HomeScreen(
                        onCardClick = {
                            scope.launch { sheetState.show() }
                        }, onPersonalityClick = { openDialog = true })
                }

                composable("offers") { ProfileSettingsScreen() }
                composable("vendors") { AttendanceScreen() }
                composable("news") { Screen("News Screen") }
                composable("consultant") { Screen("Profile Screen") }
            }
            PersonalityDialog(
                openDialog = openDialog,
                onDismiss = { openDialog = false }
            )
        }
    }
}


@Composable
fun HomeScreen(onCardClick: () -> Unit, onPersonalityClick: () -> Unit) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier.verticalScroll(scrollState)

    ) {
        TopAppbar()
        ImageSliderCard()
        HrCard()
        HrRequestCard()
        AmjadConsultantCard(onClick = onCardClick)
        PersonlityTest(onClick = onPersonalityClick)
        AssessmentCard()
        SurveysTabs()
        OffersCategoryPart()
        MostUsedOffersPart()

    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {

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
            bottomTabs.forEach { tab ->

                val selected = currentDestination?.route == tab.route

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(80.dp)
                        .background(
                            if (selected) CompanyColor.copy(alpha = 0.1f)
                            else Color.Transparent
                        )
                        .clickable {
                            navController.navigate(tab.route) {
                                popUpTo(bottomTabs.first().route) { inclusive = false }
                                launchSingleTop = true
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


