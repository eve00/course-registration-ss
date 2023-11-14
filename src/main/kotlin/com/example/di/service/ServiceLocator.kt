package com.example.di.service

import com.example.feature.applications.service.ApplicationApiService
import com.example.feature.applications.service.ApplicationApiServiceImpl
import com.example.feature.courses.service.CourseManagementApiService
import com.example.feature.courses.service.CourseManagementApiServiceImpl
import com.mongodb.client.MongoCollection
import org.bson.Document

object ServiceLocator {
    fun provideApplicationApiService(applicationCollection: MongoCollection<Document>): ApplicationApiService {
        return ApplicationApiServiceImpl(applicationCollection)
    }
    fun provideCourseManagementApiService(coursesCollection: MongoCollection<Document>): CourseManagementApiService {
        return CourseManagementApiServiceImpl(coursesCollection)
    }

    fun provideServiceProvider(): ServiceProvider {
        return ServiceProviderImpl()
    }
}