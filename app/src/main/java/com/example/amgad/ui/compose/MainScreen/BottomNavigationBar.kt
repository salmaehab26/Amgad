package com.example.amgad.ui.compose.MainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.amgad.ui.navigation.HomeGraph
import com.example.amgad.ui.navigation.HomeScreen
import com.example.amgad.ui.navigation.Tab2
import com.example.amgad.ui.navigation.Tab2Graph
import com.example.amgad.ui.navigation.Tab3
import com.example.amgad.ui.navigation.Tab3Graph
import com.example.amgad.ui.navigation.Tab4
import com.example.amgad.ui.navigation.Tab4Graph
import com.example.amgad.ui.navigation.Tab5
import com.example.amgad.ui.navigation.Tab5Graph
import com.example.amgad.ui.theme.CompanyColor
import com.example.app.ui.navigation.bottomTabs

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
