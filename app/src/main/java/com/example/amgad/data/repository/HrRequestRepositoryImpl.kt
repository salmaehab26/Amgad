package com.example.amgad.data.repository

import com.example.amgad.data.dataSource.DummyHrRequestDataSource
import com.example.amgad.domain.model.HrRequestItemsScreenModel
import com.example.amgad.domain.repository.IHrRequestRepository
import javax.inject.Inject

class HrRequestRepositoryImpl @Inject constructor(
    private val data: DummyHrRequestDataSource
) : IHrRequestRepository {

    override suspend fun getHrRequestItems(): List<HrRequestItemsScreenModel> {
        return data.fetchHrRequests()
    }
}