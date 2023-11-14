package com.example.feature.courses.repository

import com.example.base.http.ExceptionHandler
import com.example.feature.courses.module.CourseListResponse
import com.example.feature.courses.module.RegistrationRequest
import com.example.feature.courses.service.CourseManagementApiService
import com.example.util.BaseResponse
import com.example.util.SuccessResponse
import io.ktor.http.*

class CoursesRepositoryImpl(
    private val courseManagementApiService: CourseManagementApiService,
    private val exceptionHandler: ExceptionHandler
) : CoursesRepository {
    override suspend fun getCourses(): BaseResponse<Any> {
        val courses = courseManagementApiService.getAllCourses()
        return if (courses.isEmpty()) {
            SuccessResponse(HttpStatusCode.OK, CourseListResponse())
        } else {
            SuccessResponse(HttpStatusCode.OK, CourseListResponse(courses))

        }
    }

    override suspend fun updateCourseRegistrations(request: RegistrationRequest): BaseResponse<Any> {
        val isCreated = courseManagementApiService.updateCourseRegistrations(request)
        return if (isCreated) {
            SuccessResponse(statusCode = HttpStatusCode.Created)
        } else {
            throw exceptionHandler.respondWithSomethingWentWrongException()

        }
    }
}