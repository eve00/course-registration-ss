package com.example.feature.courses.module

import kotlinx.serialization.Serializable

@Serializable
data class Registration(
    val userId: String = "",
)

@Serializable
data class RegistrationRequest(
    val courseId: String? = null,
    val studentIds: List<String> = emptyList(),
)