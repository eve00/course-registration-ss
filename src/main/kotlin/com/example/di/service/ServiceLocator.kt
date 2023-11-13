package com.example.di.service

import com.example.feature.apply.service.ApplicationApiService
import com.example.feature.apply.service.ApplicationApiServiceImpl
import com.mongodb.client.MongoCollection
import org.bson.Document

object ServiceLocator {
    fun provideApplicationApiService(applicationCollection: MongoCollection<Document>): ApplicationApiService {
        return ApplicationApiServiceImpl(applicationCollection)
    }

    fun provideServiceProvider(): ServiceProvider {
        return ServiceProviderImpl()
    }
}