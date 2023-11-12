package com.example.di.service

import com.example.di.database.DatabaseLocator
import com.example.feature.apply.service.ApplicationApiService

class ServiceProviderImpl : ServiceProvider {
    override fun provideApplicationApiService(): ApplicationApiService {
        return ServiceLocator.provideApplicationApiService(DatabaseLocator.provideDatabase().applicationColelction)
    }

}