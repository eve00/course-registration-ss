package com.example.feature.courses.repository

import com.example.feature.courses.module.Registration
import com.example.util.BaseResponse

interface CoursesRepository {
    suspend fun getCourses() : BaseResponse<Any>
    suspend fun createCourseRegistrations(studentIds:List<Registration>) : BaseResponse<Any>
}