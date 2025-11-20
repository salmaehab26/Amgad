package com.example.amgad.data.repository

import com.example.amgad.data.data_source.DummyHrRequestDataSource
import com.example.amgad.domain.model.HrRequestModel.HrRequestItemsScreenModel
import com.example.amgad.domain.repository.IHrRequestRepository
import javax.inject.Inject

class HrRequestRepositoryImpl @Inject constructor(
    private val data: DummyHrRequestDataSource
) : IHrRequestRepository {

    override suspend fun getHrRequestItems(): List<HrRequestItemsScreenModel> {
        return data.fetchHrRequests()
    }
}