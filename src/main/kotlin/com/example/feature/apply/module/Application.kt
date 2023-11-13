package com.example.feature.apply.module

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.bson.types.ObjectId

@Serializable
data class Application(
    @SerialName("id")
    val id: String? = ObjectId().toString(),
    val userId: String? = null,
    val courseId: String? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
) {

}