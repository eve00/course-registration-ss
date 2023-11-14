package com.example.feature.courses.service

interface CourseManagementApiService {
    suspend fun getAllCourses(): Boolean
    suspend fun createRegistrations(): Boolean
}