package com.example.feature.applications.repository

import com.example.feature.applications.module.Format
import com.example.util.BaseResponse

interface ApplicationsRepository {
    suspend fun createApplication(userId: String, courseId: String, format: Format): BaseResponse<Any>
    suspend fun deleteApplication(applicationId: String): BaseResponse<Any>

}