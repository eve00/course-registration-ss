package com.example.feature.applications.service

import com.example.feature.applications.module.Format

interface ApplicationApiService {

    suspend fun createApplication(userId: String, courseId: String, format: Format): Boolean
    suspend fun deleteApplication(applicationId: String): Boolean
}