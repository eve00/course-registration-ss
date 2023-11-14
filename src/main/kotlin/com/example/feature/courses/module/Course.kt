package com.example.feature.courses.module

import kotlinx.serialization.Serializable

@Serializable
data class Course(
    val courseId: String? = null,
    val name: String? = null,
    val capacity: Int? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
)
