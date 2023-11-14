package com.example.feature.applications.module

import kotlinx.serialization.Serializable

@Serializable
data class ApplicationResponse(
    val application: Application = Application()
)