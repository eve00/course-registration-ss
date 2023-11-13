package com.example.feature.apply.domain

import com.example.base.BaseUseCase
import com.example.feature.apply.module.Application
import com.example.feature.apply.module.ApplicationResponse
import com.example.feature.apply.repository.ApplicationsRepository
import com.example.util.BaseResponse

class CreateApplicationUseCase(private val applicationsRepository: ApplicationsRepository) :
    BaseUseCase<Application, ApplicationResponse> {
    // TODO: ?:外す
    override suspend fun invoke(input: Application): BaseResponse<ApplicationResponse> {
return applicationsRepository.createApplication(userId = input.userId ?: "", courseId = input.courseId ?: "")
        as BaseResponse<ApplicationResponse>
    }

}

