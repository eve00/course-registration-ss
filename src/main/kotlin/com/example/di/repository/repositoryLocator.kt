package com.example.di.repository

import com.example.di.service.ServiceLocator
import com.example.feature.apply.repository.ApplicationsRepository
import com.example.feature.apply.repository.ApplicationsRepositoryImpl
import com.example.feature.apply.service.ApplicationApiService

object RepositoryLocator {
    fun provideApplicationRepository(applicationApiService: ApplicationApiService): ApplicationsRepository {
        return ApplicationsRepositoryImpl(
            applicationApiService
        )
    }
    fun provideRepositoryProvider(): RepositoryProvider {
        return RepositoryProviderImpl(ServiceLocator.provideServiceProvider())
    }
}