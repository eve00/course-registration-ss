package com.example.di.domain

import com.example.di.repository.RepositoryProvider
import com.example.feature.apply.domain.CreateApplicationUseCase
import com.example.feature.apply.domain.DeleteApplicationUseCase

class DomainProviderImpl(private val repositoryProvider: RepositoryProvider): DomainProvider {
    override fun provideCreateApplicationUseCase(): CreateApplicationUseCase {
        return DomainLocator.provideCreateApplicationUseCase(repositoryProvider.provideApplicationsRepository())
    }

    override fun provideDeleteApplicationUseCase(): DeleteApplicationUseCase {
        return DomainLocator.provideDeleteApplicationUseCase(repositoryProvider.provideApplicationsRepository())
    }
}