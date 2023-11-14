package com.example.feature.applications.service

interface ApplicationApiService {

    suspend fun createApplication(userId: String, courseId: String): Boolean
    suspend fun deleteApplication(applicationId: String): Boolean
}