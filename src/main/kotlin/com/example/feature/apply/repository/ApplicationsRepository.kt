package com.example.feature.apply.repository

interface ApplicationsRepository {
    suspend fun createApplication(userId: String, courseId: String): Boolean
    suspend fun deleteApplication(applicationId: String): Boolean

}