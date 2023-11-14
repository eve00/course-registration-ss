package com.example.feature.courses.repository

import com.example.base.http.ExceptionHandler
import com.example.feature.courses.service.CourseManagementApiService

class CoursesRepositoryImpl(private val courseManagementApiservice: CourseManagementApiService, private val exceptionHandler: ExceptionHandler):CoursesRepository {
    override suspend fun getCourses() {
        TODO("Not yet implemented")
    }

    override suspend fun createCourseRegistrations(studentIds: List<String>) {
        TODO("Not yet implemented")
    }
}