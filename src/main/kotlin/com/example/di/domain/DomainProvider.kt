package com.example.di.domain

import com.example.feature.applications.domain.CreateApplicationUseCase
import com.example.feature.applications.domain.DeleteApplicationUseCase
import com.example.feature.courses.domain.CreateRegistrationsUseCase
import com.example.feature.courses.domain.GetAllCoursesUseCase

interface DomainProvider {
    fun provideCreateApplicationUseCase(): CreateApplicationUseCase
    fun provideDeleteApplicationUseCase(): DeleteApplicationUseCase

    fun provideGetAllCoursesUseCase(): GetAllCoursesUseCase
    fun provideCreateRegistrationsUseCase(): CreateRegistrationsUseCase
}