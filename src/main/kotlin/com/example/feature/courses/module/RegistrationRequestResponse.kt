package com.example.feature.courses.module

import kotlinx.serialization.Serializable

@Serializable
data class RegistrationRequestResponse(
    val registrationRequest: RegistrationRequest = RegistrationRequest()
)