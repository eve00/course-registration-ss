package com.example.feature.apply.domain

import com.example.base.BaseUseCase
import com.example.feature.apply.Application
import com.example.feature.apply.repository.ApplicationsRepository
import com.example.util.BaseResponse

class DeleteApplicationUseCase(private val applicationsRepository: ApplicationsRepository) :
    BaseUseCase<Application, Any> {
    override suspend fun invoke(input: Application): BaseResponse<Any> {
        return applicationsRepository.deleteApplication(input.applicatonId ?:"")   }

}