package com.example.di.service

import com.example.feature.apply.service.ApplicationApiService

interface ServiceProvider {
    fun provideApplicationApiService(): ApplicationApiService
}