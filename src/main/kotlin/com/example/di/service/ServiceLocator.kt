package com.example.di.service

import com.example.feature.apply.Application
import com.example.feature.apply.service.ApplicationApiService
import com.example.feature.apply.service.ApplicationApiServiceImpl
import org.litote.kmongo.coroutine.CoroutineCollection

object ServiceLocator {
    fun provideApplicationApiService(applicationCollection: CoroutineCollection<Application>): ApplicationApiService {
        return ApplicationApiServiceImpl(applicationCollection)
    }

    fun provideServiceProvider(): ServiceProvider {
        return ServiceProviderImpl()
    }
}