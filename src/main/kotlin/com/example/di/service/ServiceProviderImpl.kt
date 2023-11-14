package com.example.di.service

import com.example.di.database.DatabaseLocator
import com.example.feature.applications.service.ApplicationApiService
import com.example.feature.courses.service.CourseManagementApiService

class ServiceProviderImpl : ServiceProvider {
    override fun provideApplicationApiService(): ApplicationApiService {
        return ServiceLocator.provideApplicationApiService(DatabaseLocator.provideDatabase().applicationColelction)
    }

    override fun provideCourseManagementApiService(): CourseManagementApiService {
        return ServiceLocator.provideCourseManagementApiService(DatabaseLocator.provideDatabase().courseCollection)
    }

}