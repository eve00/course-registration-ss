package com.example.feature.courses.module

import kotlinx.serialization.Serializable

@Serializable
data class RegistrationListResponse(
    val registrationList:List<Registration> = emptyList()
)