package com.example.amgad.domain.repository

import com.example.amgad.domain.model.MyLibraryModel.MyLibraryModel

interface IMyLibraryRepository {
    suspend fun getLibraryItems(): List<MyLibraryModel>

}