package com.example.di.repository

import com.example.feature.applications.repository.ApplicationsRepository
import com.example.feature.courses.repository.CoursesRepository

interface RepositoryProvider {
    fun provideApplicationsRepository(): ApplicationsRepository
    fun provideCoursesRepository(): CoursesRepository



}