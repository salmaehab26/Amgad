package com.example.amgad.ui.viewModel.HomeViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amgad.domain.model.AssessmentModel
import com.example.amgad.domain.useCase.GetAssessmentsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AssessmentsViewModel @Inject constructor(
    private val getAssessments: GetAssessmentsUseCase
) : ViewModel() {


    private val _assessments = MutableStateFlow<List<AssessmentModel>>(emptyList())
    val assessments: StateFlow<List<AssessmentModel>> = _assessments

    init {
        loadAll()
    }

    private fun loadAll() {
        viewModelScope.launch {
            _assessments.value = getAssessments()
        }
    }
}

