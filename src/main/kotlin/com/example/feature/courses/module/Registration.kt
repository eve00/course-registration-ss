package com.example.feature.courses.module

import kotlinx.serialization.Serializable

@Serializable
data class Registration(
    val userId: String? = null,
    val courseId: String? = null,
)
