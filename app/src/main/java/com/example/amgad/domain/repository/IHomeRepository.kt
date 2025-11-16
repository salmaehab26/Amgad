package com.example.amgad.domain.repository

import com.example.amgad.domain.model.AssessmentModel
import com.example.amgad.domain.model.HrRequestModel
import com.example.amgad.domain.model.ImageSliderModel
import com.example.amgad.domain.model.MostUsedOfferModel
import com.example.amgad.domain.model.NewsCardModel
import com.example.amgad.domain.model.OfferCategoryModel

interface IHomeRepository {
    suspend fun getSliderImages(): List<ImageSliderModel>
    suspend fun getHrRequests(): List<HrRequestModel>
    suspend fun getAssessments(): List<AssessmentModel>
    suspend fun getOfferCategory(): List<OfferCategoryModel>
    suspend fun getNews(): List<NewsCardModel>
    suspend fun getMostUsedOffers(): List<MostUsedOfferModel>

}
