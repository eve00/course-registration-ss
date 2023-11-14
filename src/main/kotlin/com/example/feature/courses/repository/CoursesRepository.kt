package com.example.feature.courses.repository

import com.example.feature.courses.module.RegistrationRequest
import com.example.util.BaseResponse

interface CoursesRepository {
    suspend fun getCourses() : BaseResponse<Any>
    suspend fun updateCourseRegistrations(request: RegistrationRequest) : BaseResponse<Any>
}