package com.example.amgad.ui.viewModel.HrRequestDetailsScreenViewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.example.amgad.ui.navigation.HrRequestDetailsScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HrRequestScreenDetailsViewModel @Inject constructor(
    public val handle: SavedStateHandle,
) : ViewModel() {
    val request = handle.toRoute<HrRequestDetailsScreen>()
    val name = request.name
    val requestId = request.requestId
    val time = request.time
    val typeTitle = request.typeTitle
    val statusName = request.statusName
    val TitleColor = request.TitleColor
    val backgroundColor = request.backgroundColor
    val borderColor = request.borderColor
}