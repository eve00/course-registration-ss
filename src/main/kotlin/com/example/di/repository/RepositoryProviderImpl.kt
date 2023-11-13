package com.example.di.repository

import com.example.di.ConfigLocator
import com.example.di.service.ServiceProvider
import com.example.feature.apply.repository.ApplicationsRepository

class RepositoryProviderImpl(private val serviceProvider: ServiceProvider) : RepositoryProvider {
    override fun provideApplicationsRepository(): ApplicationsRepository {
        return RepositoryLocator.provideApplicationRepository(
            serviceProvider.provideApplicationApiService(), ConfigLocator.provideExceptionHandler()
        )
    }
}