package com.example.feature.apply

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.bson.types.ObjectId

@Serializable
data class Application(
    @SerialName("id")
    @Contextual val id: ObjectId?,
    val userId: String? = null,
    val courseId: String? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
) {

}
