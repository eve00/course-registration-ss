package com.example.feature.courses.service

import com.example.feature.courses.module.Course
import com.example.feature.courses.module.RegistrationRequest

interface CourseManagementApiService {
    suspend fun getAllCourses(): List<Course>
    suspend fun updateCourseRegistrations(request: RegistrationRequest): Boolean
}