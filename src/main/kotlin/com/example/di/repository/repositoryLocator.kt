package com.example.di.repository

import com.example.base.http.ExceptionHandler
import com.example.di.service.ServiceLocator
import com.example.feature.apply.repository.ApplicationsRepository
import com.example.feature.apply.repository.ApplicationsRepositoryImpl
import com.example.feature.apply.service.ApplicationApiService

object RepositoryLocator {
    fun provideApplicationRepository(applicationApiService: ApplicationApiService, exceptionHandler: ExceptionHandler): ApplicationsRepository {
        return ApplicationsRepositoryImpl(
            applicationApiService,
            exceptionHandler
        )
    }
    fun provideRepositoryProvider(): RepositoryProvider {
        return RepositoryProviderImpl(ServiceLocator.provideServiceProvider())
    }
}