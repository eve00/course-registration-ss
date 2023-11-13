package com.example.feature.apply.repository

import com.example.util.BaseResponse

interface ApplicationsRepository {
    suspend fun createApplication(userId: String, courseId: String): BaseResponse<Any>
    suspend fun deleteApplication(applicationId: String): BaseResponse<Any>

}