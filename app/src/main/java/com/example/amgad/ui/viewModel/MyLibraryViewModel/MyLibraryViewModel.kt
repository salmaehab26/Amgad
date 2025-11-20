package com.example.amgad.ui.viewModel.MyLibraryViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amgad.domain.model.MyLibraryModel.ItemType
import com.example.amgad.domain.model.MyLibraryModel.MyLibraryModel
import com.example.amgad.domain.useCase.MyLibraryUseCase.GetMyLibraryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyLibraryViewModel @Inject constructor(
    private val getMyLibraryUseCase: GetMyLibraryUseCase
) : ViewModel() {

    private val _items = MutableStateFlow<List<MyLibraryModel>>(emptyList())
    val items: StateFlow<List<MyLibraryModel>> = _items.asStateFlow()

    private val _selectedType = MutableStateFlow(ItemType.Video)
    val selectedType: StateFlow<ItemType> = _selectedType.asStateFlow()

    val filteredItems: StateFlow<List<MyLibraryModel>> =
        combine(_items, _selectedType) { items, type ->
            items.filter { it.type == type }
        }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    init {
        loadItems()
    }

    private fun loadItems() {
        viewModelScope.launch {
            val data = getMyLibraryUseCase()
            _items.value = data
        }
    }

    fun onTypeSelected(type: ItemType) {
        _selectedType.value = type
    }

}