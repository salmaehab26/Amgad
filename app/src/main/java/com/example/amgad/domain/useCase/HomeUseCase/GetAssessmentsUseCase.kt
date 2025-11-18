package com.example.amgad.domain.useCase

import com.example.amgad.domain.model.AssessmentModel
import com.example.amgad.domain.repository.IHomeRepository
import javax.inject.Inject

class GetAssessmentsUseCase @Inject constructor(
    private val repo: IHomeRepository
) {
    suspend operator fun invoke(): List<AssessmentModel> = repo.getAssessments()
}
