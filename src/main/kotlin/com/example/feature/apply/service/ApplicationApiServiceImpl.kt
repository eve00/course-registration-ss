package com.example.feature.apply.service

import com.mongodb.client.MongoCollection
import com.mongodb.client.model.Filters
import org.bson.Document
import java.util.*

class ApplicationApiServiceImpl(
    private val applicationCollection: MongoCollection<Document>

) : ApplicationApiService {
    override suspend fun createApplication(userId: String, courseId: String): Boolean {
        val application = Document().append("userId", userId).append("courseId", courseId)
            .append("createdAt", Date().toInstant().toString())
            .append("updatedAt", Date().toInstant().toString())
        return applicationCollection.insertOne(application).wasAcknowledged()
    }

    override suspend fun deleteApplication(applicationId: String): Boolean {
        return applicationCollection.deleteOne(Filters.eq("_id", applicationId)).wasAcknowledged()
    }

}