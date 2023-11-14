package com.example.feature.courses.domain

import com.example.base.BaseUseCase
import com.example.feature.courses.module.Registration
import com.example.feature.courses.module.RegistrationListResponse
import com.example.feature.courses.repository.CoursesRepository
import com.example.util.BaseResponse

class CreateRegistrationsUseCase(private val coursesRepository: CoursesRepository):BaseUseCase<List<Registration>, RegistrationListResponse> {
    override suspend fun invoke(input: List<Registration>): BaseResponse<RegistrationListResponse> {
        return coursesRepository.createCourseRegistrations(input) as BaseResponse<RegistrationListResponse>
    }

}