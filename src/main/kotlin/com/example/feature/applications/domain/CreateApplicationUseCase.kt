package com.example.feature.applications.domain

import com.example.base.BaseUseCase
import com.example.feature.applications.module.Application
import com.example.feature.applications.module.ApplicationResponse
import com.example.feature.applications.repository.ApplicationsRepository
import com.example.util.BaseResponse

class CreateApplicationUseCase(private val applicationsRepository: ApplicationsRepository) :
    BaseUseCase<Application, ApplicationResponse> {
    // TODO: ?:外す
    override suspend fun invoke(input: Application): BaseResponse<ApplicationResponse> {
        return applicationsRepository.createApplication(userId = input.userId ?: "", courseId = input.courseId ?: "", format = input.format)
                as BaseResponse<ApplicationResponse>
    }

}

