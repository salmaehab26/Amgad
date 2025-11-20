package com.example.amgad.ui.viewModel.HrScreenViewModel

import com.example.amgad.domain.model.HrRequestModel.RequestStatus
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amgad.domain.model.HrRequestModel.HrRequestItemsScreenModel
import com.example.amgad.domain.useCase.HrRequestUseCase.GetHrRequestItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HrRequestScreenViewModel @Inject constructor(
    private val getHrRequestItemUseCase: GetHrRequestItemUseCase
) : ViewModel() {

    private val _items = MutableStateFlow<List<HrRequestItemsScreenModel>>(emptyList())
    val items: StateFlow<List<HrRequestItemsScreenModel>> = _items.asStateFlow()

    private val _selectedStatus = MutableStateFlow(RequestStatus.PENDING)
    val selectedStatus: StateFlow<RequestStatus> = _selectedStatus.asStateFlow()

    val filteredItems: StateFlow<List<HrRequestItemsScreenModel>> = combine(_items, _selectedStatus) { items, status ->
        items.filter { it.status == status }
    }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    init {
        loadItems()
    }

    private fun loadItems() {
        viewModelScope.launch {
            val data = getHrRequestItemUseCase()
            _items.value = data
        }
    }

    fun onStatusSelected(status: RequestStatus) {
        _selectedStatus.value = status
    }
}
