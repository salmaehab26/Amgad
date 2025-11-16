package com.example.amgad.domain.model

import androidx.annotation.DrawableRes

data class AssessmentModel(
    val title: String,
    val minutes: Int,
    val questions: Int,
    @DrawableRes val imageRes: Int
)