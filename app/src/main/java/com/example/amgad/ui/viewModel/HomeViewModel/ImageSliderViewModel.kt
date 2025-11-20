package com.example.amgad.ui.viewModel.HomeViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amgad.domain.model.MainModle.ImageSliderModel
import com.example.amgad.domain.useCase.GetSliderImagesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SliderViewModel @Inject constructor(
    private val getSliderImagesUseCase: GetSliderImagesUseCase
) : ViewModel() {

    private val _images = MutableStateFlow<List<ImageSliderModel>>(emptyList())
    val images: StateFlow<List<ImageSliderModel>> = _images

    init {
        loadImages()
    }

    private fun loadImages() {
        viewModelScope.launch {
            val result = getSliderImagesUseCase()
            _images.value = result
        }
    }
}
