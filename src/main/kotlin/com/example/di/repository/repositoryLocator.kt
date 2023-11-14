package com.example.di.repository

import com.example.base.http.ExceptionHandler
import com.example.di.service.ServiceLocator
import com.example.feature.applications.repository.ApplicationsRepository
import com.example.feature.applications.repository.ApplicationsRepositoryImpl
import com.example.feature.applications.service.ApplicationApiService
import com.example.feature.courses.repository.CoursesRepository
import com.example.feature.courses.repository.CoursesRepositoryImpl
import com.example.feature.courses.service.CourseManagementApiService

object RepositoryLocator {
    fun provideApplicationsRepository(applicationApiService: ApplicationApiService, exceptionHandler: ExceptionHandler): ApplicationsRepository {
        return ApplicationsRepositoryImpl(
            applicationApiService,
            exceptionHandler
        )
    }
    fun provideCoursesRepository(courseManagementApiservice: CourseManagementApiService, exceptionHandler: ExceptionHandler): CoursesRepository {
        return CoursesRepositoryImpl(
            courseManagementApiservice,
            exceptionHandler
        )
    }
    fun provideRepositoryProvider(): RepositoryProvider {
        return RepositoryProviderImpl(ServiceLocator.provideServiceProvider())
    }
}