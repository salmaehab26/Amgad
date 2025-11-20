package com.example.amgad.domain.repository

import com.example.amgad.domain.model.HrRequestModel.HrRequestItemsScreenModel


interface IHrRequestRepository {
    suspend fun getHrRequestItems(): List<HrRequestItemsScreenModel>

}