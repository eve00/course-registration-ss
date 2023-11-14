package com.example.feature.applications.module

import kotlinx.serialization.Serializable

@Serializable
data class Application(
    val id: String? = null,
    val userId: String? = null,
    val courseId: String? = null,
    val format: String? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
)


enum class Format(val format: String) {
    Advance("advance"),
    Firstserved("firstserved")
}
