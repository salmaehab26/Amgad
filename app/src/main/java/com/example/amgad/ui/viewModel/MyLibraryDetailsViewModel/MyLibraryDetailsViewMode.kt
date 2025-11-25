package com.example.amgad.ui.viewModel.MyLibraryDetailsViewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.example.amgad.ui.navigation.HrRequestDetailsScreen
import com.example.amgad.ui.navigation.MediaPlayerScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class MyLibraryDetailsViewMode @Inject constructor(
    public val handle: SavedStateHandle,
) : ViewModel() {
    val media = handle.toRoute<MediaPlayerScreen>()
   val title = media.title
    val description = media.description
    val mediaUrl = media.mediaUrl
    val  mediaType = media.mediaType
}