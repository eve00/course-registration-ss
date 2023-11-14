package com.example.feature.courses.service

import com.example.feature.courses.module.Course

interface CourseManagementApiService {
    suspend fun getAllCourses(): List<Course>
    suspend fun createRegistrations(studentIds:List<String>): Boolean
}