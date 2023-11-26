package com.example.feature.applications.service

import com.example.feature.applications.module.Application
import com.example.feature.applications.module.Format
import com.mongodb.client.MongoCollection
import com.mongodb.client.model.Filters
import org.bson.Document
import org.bson.types.ObjectId
import java.util.*

class ApplicationApiServiceImpl(
    private val applicationCollection: MongoCollection<Document>,
    private val courseCollection: MongoCollection<Document>

) : ApplicationApiService {
    override suspend fun getApplicationsById(userId: String): List<Application> {
        return applicationCollection.find(Filters.eq("userId",userId)).toList().map { document ->
            Application(
                id = document.getString("id"),
                userId = document.getString("id"),
                courseId = document.getString("courseId"),
                format = when (document.getString("format")) {
                 "common" -> Format.Common
                 "advance" -> Format.Advance
                 "firstserved" -> Format.Firstserved
                    else -> {Format.Common}
                },
                createdAt = document.getString("createdAt"),
                updatedAt = document.getString("updatedAt"),
            )
        }
    }

    override suspend fun createApplication(userId: String, courseId: String, format: Format): Boolean {
        when (format) {
            Format.Common -> {}
            Format.Advance -> {}
            Format.Firstserved -> {
                val canCreate = 0 <
                        courseCollection.find(Filters.eq("courseId", courseId))
                            .toList().size - applicationCollection.find(
                    Filters.eq("courseId", courseId)
                ).toList().size
                if (!canCreate)
                    return false
            }
        }

        val application =
            Document().append("id", ObjectId().toString()).append("userId", userId).append("courseId", courseId)
                .append("format", format.value)
                .append("createdAt", Date().toInstant().toString())
                .append("updatedAt", Date().toInstant().toString())
        return applicationCollection.insertOne(application).wasAcknowledged()
    }

    override suspend fun deleteApplication(applicationId: String): Boolean {
        return applicationCollection.deleteOne(Filters.eq("id", applicationId)).wasAcknowledged()
    }

}