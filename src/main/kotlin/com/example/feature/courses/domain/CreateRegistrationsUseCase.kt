package com.example.feature.courses.domain

import com.example.base.BaseUseCase
import com.example.feature.courses.module.CourseListResponse
import com.example.feature.courses.repository.CoursesRepository
import com.example.util.BaseResponse

class CreateRegistrationsUseCase(private val coursesRepository: CoursesRepository):BaseUseCase<List<String>,CourseListResponse> {
    override suspend fun invoke(input: List<String>): BaseResponse<CourseListResponse> {
        return coursesRepository.createCourseRegistrations(input) as BaseResponse<CourseListResponse>
    }

}