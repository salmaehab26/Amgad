package com.example.amgad.ui.viewModel.HomeViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amgad.domain.model.MainModle.MostUsedOfferModel
import com.example.amgad.domain.useCase.GetMostUsedOffersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class MostUsedOfferViewModel @Inject constructor(
    private val getMostUsedOffers: GetMostUsedOffersUseCase
) : ViewModel() {
    private val _offers = MutableStateFlow<List<MostUsedOfferModel>>(emptyList())
    val offers: StateFlow<List<MostUsedOfferModel>> = _offers

    init {
        loadAll()
    }

    private fun loadAll() {
        viewModelScope.launch {
            _offers.value = getMostUsedOffers()
        }
    }
}

