package com.example.amgad.domain.useCase

import com.example.amgad.domain.model.MainModle.OfferCategoryModel
import com.example.amgad.domain.repository.IHomeRepository
import javax.inject.Inject

class GetOffersUseCase @Inject constructor(
    private val repo: IHomeRepository
) {
    suspend operator fun invoke(): List<OfferCategoryModel> = repo.getOfferCategory()

}