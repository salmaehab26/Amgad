package com.example.amgad.ui.viewModel.HrScreenViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amgad.domain.model.HrRequestItemsScreenModel

import com.example.amgad.domain.useCase.HrRequestUseCase.GetHrRequestItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HrRequestScreenViewModel @Inject constructor(
    private val getHrRequestsUseCase: GetHrRequestItemUseCase
) : ViewModel() {
    private val _items = MutableStateFlow<List<HrRequestItemsScreenModel>>(emptyList())
    val offers: StateFlow<List<HrRequestItemsScreenModel>> = _items

    init {
        loadAll()
    }

    private fun loadAll() {
        viewModelScope.launch {
            _items.value = getHrRequestsUseCase()
        }
    }
}

