package com.example.feature.courses.repository

import com.example.base.http.ExceptionHandler
import com.example.feature.courses.module.CourseListResponse
import com.example.feature.courses.service.CourseManagementApiService
import com.example.util.BaseResponse
import com.example.util.SuccessResponse
import io.ktor.http.*

class CoursesRepositoryImpl(
    private val courseManagementApiservice: CourseManagementApiService,
    private val exceptionHandler: ExceptionHandler
) : CoursesRepository {
    override suspend fun getCourses(): BaseResponse<Any> {
        val courses = courseManagementApiservice.getAllCourses()
        return if (courses.isEmpty()) {
            SuccessResponse(HttpStatusCode.OK, CourseListResponse())
        } else {
            SuccessResponse(HttpStatusCode.OK, CourseListResponse(courses))

        }
    }

    override suspend fun createCourseRegistrations(studentIds: List<String>): BaseResponse<Any> {
        val isCreated = courseManagementApiservice.createRegistrations(studentIds)
        return if (isCreated) {
            SuccessResponse(statusCode = HttpStatusCode.Created)
        } else {
            throw exceptionHandler.respondWithSomethingWentWrongException()

        }
    }
}