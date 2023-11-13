package com.example.feature.apply.module

import kotlinx.serialization.Serializable

@Serializable
data class ApplicationResponse(
    val application: Application = Application()
)