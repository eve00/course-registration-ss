package com.example.feature.applications.module

import kotlinx.serialization.Serializable

@Serializable
data class ApplicationListResponse(
    val application: List<Application> = emptyList()
)