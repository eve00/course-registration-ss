package com.example.feature.apply.module

import kotlinx.serialization.Serializable

@Serializable
data class Application(
    val id: String? = null,
    val userId: String? = null,
    val courseId: String? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
) {

}
