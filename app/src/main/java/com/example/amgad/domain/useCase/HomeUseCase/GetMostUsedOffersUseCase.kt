package com.example.amgad.domain.useCase


import com.example.amgad.domain.model.MainModle.MostUsedOfferModel
import com.example.amgad.domain.repository.IHomeRepository
import javax.inject.Inject

class GetMostUsedOffersUseCase @Inject constructor(
    private val repo: IHomeRepository
) {
    suspend operator fun invoke(): List<MostUsedOfferModel> = repo.getMostUsedOffers()
}

