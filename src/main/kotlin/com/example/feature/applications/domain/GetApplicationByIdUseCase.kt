package com.example.feature.applications.domain

import com.example.base.BaseUseCase
import com.example.feature.applications.module.Application
import com.example.feature.applications.repository.ApplicationsRepository
import com.example.util.BaseResponse
import io.ktor.server.response.*

class GetApplicationsByIdUseCase(private val applicationsRepository: ApplicationsRepository) :
    BaseUseCase<Application, ApplicationResponse> {
    override suspend fun invoke(input: Application): BaseResponse<ApplicationResponse> {
        return applicationsRepository.deleteApplication(input.id.toString()) as BaseResponse<ApplicationResponse>
    }

}