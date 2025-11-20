package com.example.amgad.domain.repository

import com.example.amgad.domain.model.MainModle.AssessmentModel
import com.example.amgad.domain.model.MainModle.HrRequestModel
import com.example.amgad.domain.model.MainModle.ImageSliderModel
import com.example.amgad.domain.model.MainModle.MostUsedOfferModel
import com.example.amgad.domain.model.MainModle.NewsCardModel
import com.example.amgad.domain.model.MainModle.OfferCategoryModel

interface IHomeRepository {
    suspend fun getSliderImages(): List<ImageSliderModel>
    suspend fun getHrRequests(): List<HrRequestModel>
    suspend fun getAssessments(): List<AssessmentModel>
    suspend fun getOfferCategory(): List<OfferCategoryModel>
    suspend fun getNews(): List<NewsCardModel>
    suspend fun getMostUsedOffers(): List<MostUsedOfferModel>

}
