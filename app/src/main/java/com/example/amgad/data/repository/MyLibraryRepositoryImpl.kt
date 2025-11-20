package com.example.amgad.data.repository

import com.example.amgad.data.data_source.DummyMyLibraryDataSource
import com.example.amgad.domain.model.MyLibraryModel.MyLibraryModel
import com.example.amgad.domain.repository.IMyLibraryRepository
import javax.inject.Inject

class MyLibraryRepositoryImpl @Inject constructor(
    private val data: DummyMyLibraryDataSource
) : IMyLibraryRepository {
    override suspend fun getLibraryItems(): List<MyLibraryModel> {
        return data.fetchLibraryItems()
    }

}