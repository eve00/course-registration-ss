package com.example.feature.apply.repository

import com.example.base.http.ExceptionHandler
import com.example.feature.apply.service.ApplicationApiService
import com.example.util.BaseResponse
import com.example.util.SuccessResponse
import io.ktor.http.*

class ApplicationsRepositoryImpl(

    private val applicationApiService: ApplicationApiService,
    private val exceptionHandler: ExceptionHandler

) : ApplicationsRepository {
    override suspend fun createApplication(userId: String, courseId: String): BaseResponse<Any> {
        val isCreated = applicationApiService.createApplication(userId, courseId)
        return if (isCreated) {
            SuccessResponse(statusCode = HttpStatusCode.Created)
        } else {
            throw exceptionHandler.respondWithSomethingWentWrongException()

        }
    }

    override suspend fun deleteApplication(applicationId: String): BaseResponse<Any> {
        val isDeleted = applicationApiService.deleteApplication(applicationId)
        return if (isDeleted) {
            SuccessResponse(statusCode = HttpStatusCode.OK)
        } else {
            throw exceptionHandler.respondWithSomethingWentWrongException()
        }
    }

}