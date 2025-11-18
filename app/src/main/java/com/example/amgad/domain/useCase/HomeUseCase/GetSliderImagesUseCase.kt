package com.example.amgad.domain.useCase

import com.example.amgad.domain.model.ImageSliderModel
import com.example.amgad.domain.repository.IHomeRepository
import javax.inject.Inject

class GetSliderImagesUseCase @Inject constructor(
    private val repository: IHomeRepository
) {
    suspend operator fun invoke(): List<ImageSliderModel> = repository.getSliderImages()
}