package com.example.amgad.domain.useCase

import com.example.amgad.domain.model.MainModle.NewsCardModel
import com.example.amgad.domain.repository.IHomeRepository
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val repo: IHomeRepository
) {
    suspend operator fun invoke(): List<NewsCardModel> = repo.getNews()
}
