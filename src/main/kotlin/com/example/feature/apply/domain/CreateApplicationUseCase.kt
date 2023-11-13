package com.example.feature.apply.domain

import com.example.base.BaseUseCase
import com.example.feature.apply.Application
import com.example.feature.apply.repository.ApplicationsRepository
import com.example.util.BaseResponse

class CreateApplicationUseCase(private val applicationsRepository: ApplicationsRepository) :
    BaseUseCase<Application, Any> {
    // TODO: ?:外す
    override suspend fun invoke(input: Application): BaseResponse<Any> {
return applicationsRepository.createApplication(userId = input.userId ?: "", courseId = input.courseId ?: "")   }

}

