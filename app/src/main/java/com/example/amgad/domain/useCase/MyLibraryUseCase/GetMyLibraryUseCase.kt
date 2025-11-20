package com.example.amgad.domain.useCase.MyLibraryUseCase
import com.example.amgad.domain.model.MyLibraryModel.MyLibraryModel
import com.example.amgad.domain.repository.IMyLibraryRepository
import javax.inject.Inject

class GetMyLibraryUseCase @Inject constructor(
    private val repo: IMyLibraryRepository
) {
    suspend operator fun invoke(): List<MyLibraryModel> = repo.getLibraryItems()
}
