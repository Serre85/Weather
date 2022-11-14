package com.hslee.domain.di

import com.hslee.domain.repository.WeathersRepository
import com.hslee.domain.usecase.WeathersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideWeatherUseCase(repository: WeathersRepository): WeathersUseCase {
        return WeathersUseCase(repository)
    }
}