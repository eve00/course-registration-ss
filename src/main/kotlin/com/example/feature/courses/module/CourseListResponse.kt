package com.example.feature.courses.module

import kotlinx.serialization.Serializable

@Serializable
data class CourseListResponse(
    val cats: List<Course> = emptyList()
)