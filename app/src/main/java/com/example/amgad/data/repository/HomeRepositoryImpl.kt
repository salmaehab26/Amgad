package com.example.amgad.data.repository

import com.example.amgad.data.datasource.DummyHomeDataSource
import com.example.amgad.domain.model.AssessmentModel
import com.example.amgad.domain.model.HrRequestModel
import com.example.amgad.domain.model.ImageSliderModel
import com.example.amgad.domain.model.MostUsedOfferModel
import com.example.amgad.domain.model.NewsCardModel
import com.example.amgad.domain.model.OfferCategoryModel
import com.example.amgad.domain.repository.IHomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val data: DummyHomeDataSource
) : IHomeRepository {

    override suspend fun getSliderImages(): List<ImageSliderModel> {
        return data.fetchSliderImages()
    }


    override suspend fun getHrRequests(): List<HrRequestModel> {
        return data.fetchHrRequestCardData()
    }

    override suspend fun getAssessments(): List<AssessmentModel> {
        return data.fetchAssessments()    }

    override suspend fun getOfferCategory(): List<OfferCategoryModel> {
        return data.fetchOffersCategory()
    }

    override suspend fun getNews(): List<NewsCardModel> {
        return data.fetchNews()
    }

    override suspend fun getMostUsedOffers(): List<MostUsedOfferModel> {
        return data.fetchMostUsedOffers()    }
}
