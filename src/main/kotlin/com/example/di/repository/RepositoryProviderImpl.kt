package com.example.di.repository

import com.example.di.ConfigLocator
import com.example.di.service.ServiceProvider
import com.example.feature.applications.repository.ApplicationsRepository
import com.example.feature.courses.repository.CoursesRepository

class RepositoryProviderImpl(private val serviceProvider: ServiceProvider) : RepositoryProvider {
    override fun provideApplicationsRepository(): ApplicationsRepository {
        return RepositoryLocator.provideApplicationsRepository(
            serviceProvider.provideApplicationApiService(), ConfigLocator.provideExceptionHandler()
        )
    }

    override fun provideCoursesRepository(): CoursesRepository {
        return RepositoryLocator.provideCoursesRepository(
            serviceProvider.provideCourseManagementApiService(), ConfigLocator.provideExceptionHandler()

        )
    }
}