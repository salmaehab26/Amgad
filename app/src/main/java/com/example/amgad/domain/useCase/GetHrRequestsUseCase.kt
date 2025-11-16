package com.example.amgad.domain.useCase
import com.example.amgad.domain.repository.IHomeRepository
import javax.inject.Inject

class GetHrRequestsUseCase@Inject constructor(
    private val repository: IHomeRepository
) {
    suspend operator fun invoke() = repository.getHrRequests()
}
