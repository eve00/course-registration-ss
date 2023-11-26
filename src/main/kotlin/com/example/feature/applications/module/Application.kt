package com.example.feature.applications.module

import kotlinx.serialization.Serializable

@Serializable
data class Application(
    val id: String? = null,
    val userId: String? = null,
    val courseId: String? = null,
    val format: Format,
    val createdAt: String? = null,
    val updatedAt: String? = null,
)


enum class Format(val value: String) {
    Common("common"),
    Advance("advance"),
    Firstserved("firstserved")
}
