package com.example.di.domain

import com.example.di.repository.RepositoryLocator
import com.example.feature.applications.domain.CreateApplicationUseCase
import com.example.feature.applications.domain.DeleteApplicationUseCase
import com.example.feature.applications.repository.ApplicationsRepository
import com.example.feature.courses.domain.CreateRegistrationsUseCase
import com.example.feature.courses.domain.GetAllCoursesUseCase
import com.example.feature.courses.repository.CoursesRepository

object DomainLocator {
    fun provideCreateApplicationUseCase(applicationsRepository: ApplicationsRepository) : CreateApplicationUseCase {
        return CreateApplicationUseCase(applicationsRepository)
    }

    fun provideDeleteApplicationUseCase(applicationsRepository: ApplicationsRepository) : DeleteApplicationUseCase {
        return DeleteApplicationUseCase(applicationsRepository)
    }

    fun provideGetAllCoursesUseCase(coursesRepository: CoursesRepository): GetAllCoursesUseCase {
        return GetAllCoursesUseCase(coursesRepository)
    }

    fun provideCreateRegistrationsUseCase(coursesRepository: CoursesRepository):CreateRegistrationsUseCase {
        return CreateRegistrationsUseCase(coursesRepository)
    }

    fun provideDomainProvider(): DomainProvider {
        return DomainProviderImpl(RepositoryLocator.provideRepositoryProvider())
    }
}