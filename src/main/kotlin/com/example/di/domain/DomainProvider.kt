package com.example.di.domain

import com.example.feature.apply.domain.CreateApplicationUseCase
import com.example.feature.apply.domain.DeleteApplicationUseCase

interface DomainProvider {
    fun provideCreateApplicationUseCase(): CreateApplicationUseCase
    fun provideDeleteApplicationUseCase(): DeleteApplicationUseCase
}