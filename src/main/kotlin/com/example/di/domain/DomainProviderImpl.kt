package com.example.di.domain

import com.example.di.repository.RepositoryProvider
import com.example.feature.applications.domain.CreateApplicationUseCase
import com.example.feature.applications.domain.DeleteApplicationUseCase
import com.example.feature.courses.domain.UpdateCourseRegistrationsUseCase
import com.example.feature.courses.domain.GetAllCoursesUseCase

class DomainProviderImpl(private val repositoryProvider: RepositoryProvider): DomainProvider {
    override fun provideCreateApplicationUseCase(): CreateApplicationUseCase {
        return DomainLocator.provideCreateApplicationUseCase(repositoryProvider.provideApplicationsRepository())
    }

    override fun provideDeleteApplicationUseCase(): DeleteApplicationUseCase {
        return DomainLocator.provideDeleteApplicationUseCase(repositoryProvider.provideApplicationsRepository())
    }

    override fun provideGetAllCoursesUseCase(): GetAllCoursesUseCase {
       return  DomainLocator.provideGetAllCoursesUseCase(repositoryProvider.provideCoursesRepository())
    }

    override fun provideCreateRegistrationsUseCase(): UpdateCourseRegistrationsUseCase {
        return  DomainLocator.provideCreateRegistrationsUseCase(repositoryProvider.provideCoursesRepository())
    }
}