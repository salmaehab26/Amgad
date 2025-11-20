package com.example.amgad.di

import com.example.amgad.data.data_source.DummyHomeDataSource
import com.example.amgad.data.data_source.DummyHrRequestDataSource
import com.example.amgad.data.data_source.DummyMyLibraryDataSource

import com.example.amgad.data.repository.HomeRepositoryImpl
import com.example.amgad.data.repository.HrRequestRepositoryImpl
import com.example.amgad.data.repository.MyLibraryRepositoryImpl
import com.example.amgad.domain.repository.IHomeRepository
import com.example.amgad.domain.repository.IHrRequestRepository
import com.example.amgad.domain.repository.IMyLibraryRepository
import com.example.amgad.domain.useCase.GetAssessmentsUseCase
import com.example.amgad.domain.useCase.GetHrRequestsUseCase
import com.example.amgad.domain.useCase.GetMostUsedOffersUseCase
import com.example.amgad.domain.useCase.GetNewsUseCase
import com.example.amgad.domain.useCase.GetOffersUseCase
import com.example.amgad.domain.useCase.GetSliderImagesUseCase
import com.example.amgad.domain.useCase.HrRequestUseCase.GetHrRequestItemUseCase
import com.example.amgad.domain.useCase.MyLibraryUseCase.GetMyLibraryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDummyHomeDataSource(): DummyHomeDataSource = DummyHomeDataSource()
    @Provides
    @Singleton
    fun provideDummyMyLibraryDataSource(): DummyMyLibraryDataSource = DummyMyLibraryDataSource()

    @Provides
    @Singleton
    fun provideDummyHrRequestDataSource(): DummyHrRequestDataSource = DummyHrRequestDataSource()

    @Provides
    @Singleton
    fun provideHomeRepository(
        remote: DummyHomeDataSource,
    ): IHomeRepository = HomeRepositoryImpl(remote)

    @Provides
    @Singleton
    fun provideMyLibraryRepository(
        remote: DummyMyLibraryDataSource,
    ): IMyLibraryRepository = MyLibraryRepositoryImpl(remote)

    @Provides
    @Singleton
    fun provideHrRequestRepository(
        remote: DummyHrRequestDataSource,
    ): IHrRequestRepository = HrRequestRepositoryImpl(remote)

    @Provides
    @Singleton
    fun provideGetSliderImagesUseCase(
        repository: IHomeRepository
    ): GetSliderImagesUseCase = GetSliderImagesUseCase(repository)

    @Provides
    @Singleton
    fun provideGetHrRequestsUseCase(
        repository: IHomeRepository
    ): GetHrRequestsUseCase = GetHrRequestsUseCase(repository)


    @Provides
    @Singleton
    fun provideGetAssessmentsUseCase(repository: IHomeRepository): GetAssessmentsUseCase =
        GetAssessmentsUseCase(repository)

    @Provides
    @Singleton
    fun provideGetOffersUseCase(repository: IHomeRepository): GetOffersUseCase =
        GetOffersUseCase(repository)

    @Provides
    @Singleton
    fun provideGetNewsUseCase(repository: IHomeRepository): GetNewsUseCase =
        GetNewsUseCase(repository)

    @Provides
    @Singleton
    fun provideGetMostUsedOffersUseCase(repository: IHomeRepository): GetMostUsedOffersUseCase =
        GetMostUsedOffersUseCase(repository)
    @Provides
    @Singleton
    fun provideGetHrRequestItemsUseCase(repository: IHrRequestRepository): GetHrRequestItemUseCase =
        GetHrRequestItemUseCase(repository)

    @Provides
    @Singleton
    fun provideGetMyLibraryUseCase(
        repository: IMyLibraryRepository
    ): GetMyLibraryUseCase = GetMyLibraryUseCase(repository)


}
