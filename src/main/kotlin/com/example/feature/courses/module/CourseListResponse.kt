package com.example.feature.courses.module

import kotlinx.serialization.Serializable

@Serializable
data class CourseListResponse(
    val courses: List<Course> = emptyList()
)