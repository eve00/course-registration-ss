package com.example.di.service

import com.example.feature.applications.service.ApplicationApiService
import com.example.feature.courses.service.CourseManagementApiService

interface ServiceProvider {
    fun provideApplicationApiService(): ApplicationApiService
    fun provideCourseManagementApiService(): CourseManagementApiService
}