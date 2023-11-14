package com.example.feature.courses.repository

import com.example.util.BaseResponse

interface CoursesRepository {
    suspend fun getCourses() : BaseResponse<Any>
    suspend fun createCourseRegistrations(studentIds:List<String>) : BaseResponse<Any>
}