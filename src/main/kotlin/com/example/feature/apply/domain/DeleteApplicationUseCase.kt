package com.example.feature.apply.domain

import com.example.base.BaseUseCase
import com.example.feature.apply.module.Application
import com.example.feature.apply.repository.ApplicationsRepository
import com.example.util.BaseResponse
import io.ktor.server.response.*

class DeleteApplicationUseCase(private val applicationsRepository: ApplicationsRepository) :
    BaseUseCase<Application, ApplicationResponse> {
    override suspend fun invoke(input: Application): BaseResponse<ApplicationResponse> {
        return applicationsRepository.deleteApplication(input.id.toString()) as BaseResponse<ApplicationResponse>
    }

}