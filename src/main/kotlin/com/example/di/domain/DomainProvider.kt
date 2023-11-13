package com.example.di.domain

import com.example.feature.apply.domain.CreateApplicationUseCase

interface DomainProvider {
    fun provideCreateApplicationUseCase(): CreateApplicationUseCase
}