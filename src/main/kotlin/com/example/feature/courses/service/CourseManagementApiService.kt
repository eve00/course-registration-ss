package com.example.feature.courses.service

import com.example.feature.courses.module.Course
import com.example.feature.courses.module.Registration

interface CourseManagementApiService {
    suspend fun getAllCourses(): List<Course>
    suspend fun createRegistrations(studentIds:List<Registration>): Boolean
}