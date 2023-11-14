package com.example.di.domain

import com.example.feature.applications.domain.CreateApplicationUseCase
import com.example.feature.applications.domain.DeleteApplicationUseCase
import com.example.feature.courses.domain.GetAllCoursesUseCase
import com.example.feature.courses.domain.UpdateCourseRegistrationsUseCase

interface DomainProvider {
    fun provideCreateApplicationUseCase(): CreateApplicationUseCase
    fun provideDeleteApplicationUseCase(): DeleteApplicationUseCase

    fun provideGetAllCoursesUseCase(): GetAllCoursesUseCase
    fun provideCreateRegistrationsUseCase(): UpdateCourseRegistrationsUseCase
}