package com.example.feature.apply

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class Application(
    @BsonId
    val applicatonId: String = ObjectId().toString(),
    val userId: String? = null,
    val courseId: String? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
)

data class ApplicationList(
    val applicatonId: String? = null,
    val userId: String? = null,
    val courseId: String? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
)