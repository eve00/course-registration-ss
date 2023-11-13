package com.example.di.repository

import com.example.feature.apply.repository.ApplicationsRepository

interface RepositoryProvider {
    fun provideApplicationsRepository(): ApplicationsRepository


}