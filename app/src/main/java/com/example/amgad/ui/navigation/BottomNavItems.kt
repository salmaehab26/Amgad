package com.example.app.ui.navigation

import android.graphics.Color
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.amgad.R
import com.example.amgad.ui.theme.CompanyColor
import com.example.amgad.ui.theme.Gray

data class BottomTab(
    val route: String,
    val selectedIcon: Int,
    val unSelectedIcon: Int,

)

val bottomTabs = listOf(
    BottomTab("home",R.drawable.ic_home_fill, R.drawable.ic_home_outline),
    BottomTab("offers", R.drawable.ic_offers_fill, R.drawable.ic_offers_outline),
    BottomTab("vendors", R.drawable.ic_vendors_fill, R.drawable.ic_vendors_outline),
    BottomTab("news",R.drawable.ic_news_fill, R.drawable.ic_news_outline),
    BottomTab("consultant", R.drawable.ic_my_consultant_fill, R.drawable.ic_my_consultant_outline,)
)
