package com.example.feature.apply.repository

import com.example.feature.apply.service.ApplicationApiService

class ApplicationsRepositoryImpl(

    private val applicationApiService: ApplicationApiService,
) : ApplicationsRepository {
    // TODO: exception handling
    override suspend fun createApplication(userId: String, courseId: String): Boolean {
        return applicationApiService.createApplication(userId, courseId)
    }

    override suspend fun deleteApplication(applicationId: String): Boolean {
        return applicationApiService.deleteApplication(applicationId)
    }

}