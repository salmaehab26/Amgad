package com.example.amgad.ui.compose.MainScreen

import android.app.Activity
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.*
import com.example.amgad.ui.navigation.HomeGraph
import com.example.amgad.ui.navigation.HomeScreen
import com.example.amgad.ui.navigation.Tab2
import com.example.amgad.ui.navigation.Tab3
import com.example.amgad.ui.navigation.Tab4
import com.example.amgad.ui.navigation.Tab5
import com.example.amgad.ui.navigation.attendanceGraph
import com.example.amgad.ui.navigation.homeGraph
import com.example.amgad.ui.navigation.hrRequestGraph
import com.example.amgad.ui.navigation.myLibraryGraph
import com.example.amgad.ui.navigation.profileGraph
import com.example.amgad.ui.navigation.uploadDocumentGraph
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
    val context = LocalContext.current
    val activity = context as? Activity
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
    BackHandler {
        val currentRoute = currentDestination?.route
        val homeRoute = HomeScreen::class.qualifiedName

        if (currentRoute != homeRoute && currentRoute in routesWithBottomBar) {
            navController.navigate(HomeGraph) {
                popUpTo(HomeGraph) { inclusive = false }
                launchSingleTop = true
                restoreState = true
            }}
            else if (currentRoute == homeRoute) {
                activity?.finish()

        } else {
            navController.popBackStack()
        }
    }
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
                        BottomNavigationBar(
                            navController, modifier = Modifier.padding(
                                WindowInsets.navigationBars.asPaddingValues()
                            )
                        )
                    }
                }
            ) { padding ->
                Box(
                    Modifier
                        .padding(padding)
                ) {
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
                        profileGraph(
                            navController = navController,
                        )
                        myLibraryGraph(navController = navController)
                        hrRequestGraph(navController = navController)
                        attendanceGraph(navController = navController)
                        uploadDocumentGraph(navController = navController)
                        Tab2
                        Tab3
                        Tab4
                        Tab5
                    }
                }
            }
        }

        if (openDialog) {
            PersonalityDialog(
                openDialog = openDialog,
                onDismiss = { openDialog = false }
            )
        }
    }
}





