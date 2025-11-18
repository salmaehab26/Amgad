package com.example.amgad.ui.viewModel.HomeViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amgad.domain.model.OfferCategoryModel
import com.example.amgad.domain.useCase.GetOffersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class OfferCategoryViewModel @Inject constructor(
        private val getOffers: GetOffersUseCase
    ) : ViewModel() {


        private val _offers = MutableStateFlow<List<OfferCategoryModel>>(emptyList())
        val offers: StateFlow<List<OfferCategoryModel>> = _offers

        init {
            loadAll()
        }

        private fun loadAll() {
            viewModelScope.launch {
                _offers.value = getOffers()
            }
        }

}