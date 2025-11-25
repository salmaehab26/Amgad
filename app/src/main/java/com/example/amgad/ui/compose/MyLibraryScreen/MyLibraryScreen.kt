package com.example.amgad.ui.compose.MyLibraryScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.amgad.domain.model.MyLibraryModel.ItemType
import com.example.amgad.domain.model.MyLibraryModel.MyLibraryModel
import com.example.amgad.ui.compose.HrRequestScreen.TabsRow
import com.example.amgad.ui.compose.TopBar
import com.example.amgad.ui.theme.WhiteBackground
import com.example.amgad.ui.viewModel.MyLibraryViewModel.MyLibraryViewModel


@Composable
fun MyLibraryScreen(
    viewModel: MyLibraryViewModel = hiltViewModel(),
    onNavigateBack: () -> Unit,
    onNavigateToMediaPlayer: (MyLibraryModel) -> Unit

) {
    val filteredItems by viewModel.filteredItems.collectAsState()
    val selectedType by viewModel.selectedType.collectAsState()

    MyLibraryScreenPart(
        items = filteredItems,
        type = selectedType,
        onTypeSelected = { viewModel.onTypeSelected(it) },
        onNavigateBack = onNavigateBack, onNavigateToMediaPlayer = onNavigateToMediaPlayer
    )
}

@Composable
fun MyLibraryScreenPart(
    onNavigateToMediaPlayer: (MyLibraryModel) -> Unit,
    items: List<MyLibraryModel>,
    type: ItemType,
    onTypeSelected: (ItemType) -> Unit,
    onNavigateBack: () -> Unit
) {

    val tabs = listOf("مقالات", "ملفات صوتية", "فيديو")
    val Types = listOf(ItemType.Article, ItemType.Audio, ItemType.Video)
    val selectedTab = Types.indexOf(type).takeIf { it >= 0 } ?: 2
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F5FB))
           ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TopBar(
            title = "مكتبتي", onNavigateBack = onNavigateBack,
            showIcon = false
        )

        Spacer(modifier = Modifier.height(20.dp).fillMaxWidth().background(WhiteBackground))

        TabsRow(tabs = tabs, selectedTab = selectedTab, onTabSelected = { index ->
            onTypeSelected(Types[index])
        })

        Spacer(modifier = Modifier.height(25.dp))

        ItemList(items, onNavigateToMediaPlayer)

    }
}


@Composable
fun ItemList(
    items: List<MyLibraryModel>, onNavigateToMediaPlayer: (MyLibraryModel) -> Unit
) {
    LazyColumn {
        items(items, key = { it.title }) { item ->
            CardItem(
                item = item,
                onCardClick = {
                    if (item.videoUrl != null ||
                        item.type == ItemType.Article ||
                        item.type == ItemType.Audio) {
                        onNavigateToMediaPlayer(item)
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

