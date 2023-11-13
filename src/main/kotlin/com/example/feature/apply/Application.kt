package com.example.feature.apply

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@Serializable
data class Application(
    @BsonId
    val applicatonId: String = ObjectId().toString(),
    val userId: String? = null,
    val courseId: String? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
)
