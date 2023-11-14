package com.example.feature.courses.domain

import com.example.feature.courses.module.CourseListResponse
import com.example.feature.courses.repository.CoursesRepository
import com.example.util.BaseResponse

class GetAllCoursesUseCase(private val coursesRepository: CoursesRepository)
{
    suspend fun invoke(): BaseResponse<CourseListResponse> {
        return coursesRepository.getCourses() as BaseResponse<CourseListResponse>
    }
}