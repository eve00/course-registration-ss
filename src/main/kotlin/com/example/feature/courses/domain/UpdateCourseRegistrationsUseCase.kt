package com.example.feature.courses.domain

import com.example.base.BaseUseCase
import com.example.feature.courses.module.RegistrationRequest
import com.example.feature.courses.module.RegistrationRequestResponse
import com.example.feature.courses.repository.CoursesRepository
import com.example.util.BaseResponse

class UpdateCourseRegistrationsUseCase(private val coursesRepository: CoursesRepository):BaseUseCase<RegistrationRequest, RegistrationRequestResponse> {
    override suspend fun invoke(input: RegistrationRequest): BaseResponse<RegistrationRequestResponse> {
        return coursesRepository.updateCourseRegistrations(input) as BaseResponse<RegistrationRequestResponse>
    }
}