package com.example.amgad.ui.viewModel.HomeViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amgad.domain.model.NewsCardModel
import com.example.amgad.domain.useCase.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNews: GetNewsUseCase
) : ViewModel() {


    private val _news = MutableStateFlow<List<NewsCardModel>>(emptyList())
    val news: StateFlow<List<NewsCardModel>> = _news

    init {
        loadAll()
    }

    private fun loadAll() {
        viewModelScope.launch {
            _news.value = getNews()
        }
    }
}

