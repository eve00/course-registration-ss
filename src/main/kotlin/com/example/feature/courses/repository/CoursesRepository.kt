package com.example.feature.courses.repository

interface CoursesRepository {
    suspend fun getCourses()
    suspend fun createCourseRegistrations(studentIds:List<String>)
}