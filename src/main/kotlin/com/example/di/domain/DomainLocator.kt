package com.example.di.domain

import com.example.di.repository.RepositoryLocator
import com.example.feature.apply.domain.CreateApplicationUseCase
import com.example.feature.apply.repository.ApplicationsRepository

object DomainLocator {
    fun provideCreateApplicationUseCase(applicationsRepository: ApplicationsRepository) : CreateApplicationUseCase {
        return CreateApplicationUseCase(applicationsRepository)
    }

    fun provideDomainProvider(): DomainProvider {
        return DomainProviderImpl(RepositoryLocator.provideRepositoryProvider())
    }
}