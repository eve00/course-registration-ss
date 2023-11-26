package com.example.feature.applications.repository

import com.example.base.http.ExceptionHandler
import com.example.feature.applications.module.ApplicationListResponse
import com.example.feature.applications.module.Format
import com.example.feature.applications.service.ApplicationApiService
import com.example.util.BaseResponse
import com.example.util.SuccessResponse
import io.ktor.http.*

class ApplicationsRepositoryImpl(

    private val applicationApiService: ApplicationApiService,
    private val exceptionHandler: ExceptionHandler

) : ApplicationsRepository {
    override suspend fun getApplicationsById(userId: String): BaseResponse<ApplicationListResponse> {

        val applications = applicationApiService.getApplicationsById(userId)
        return if (applications.isEmpty()) {
            SuccessResponse(HttpStatusCode.OK, ApplicationListResponse())
        } else {
            SuccessResponse(HttpStatusCode.OK, ApplicationListResponse(applications))

        }    }

    override suspend fun createApplication(userId: String, courseId: String, format: Format): BaseResponse<Any> {
        val isCreated = applicationApiService.createApplication(userId, courseId, format)
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