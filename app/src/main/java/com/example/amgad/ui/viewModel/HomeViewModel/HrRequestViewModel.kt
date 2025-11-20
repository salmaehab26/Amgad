package com.example.amgad.ui.viewModel.HomeViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amgad.domain.model.MainModle.HrRequestModel
import com.example.amgad.domain.useCase.GetHrRequestsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

    @HiltViewModel
class HrRequestViewModel @Inject constructor(
    private val getHrRequestsUseCase: GetHrRequestsUseCase
) : ViewModel() {

    private val _items = MutableStateFlow<List<HrRequestModel>>(emptyList())
    val items: StateFlow<List<HrRequestModel>> = _items

    init {
        loadRequests()
    }

    private fun loadRequests() {
        viewModelScope.launch {
           _items.value =  getHrRequestsUseCase()
        }
    }
}
