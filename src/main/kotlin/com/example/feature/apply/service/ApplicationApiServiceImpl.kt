package com.example.feature.apply.service

import com.example.feature.apply.Application
import org.litote.kmongo.coroutine.CoroutineCollection
import java.util.*

class ApplicationApiServiceImpl(
    private val applicationCollection: CoroutineCollection<Application>

):ApplicationApiService {
    override suspend fun createApplication(userId:String, courseId: String): Boolean {
        val application = Application(userId = userId, courseId = courseId).copy(
            createdAt = Date().toInstant().toString(),
            updatedAt = Date().toInstant().toString()
        )
        return applicationCollection.insertOne(application).wasAcknowledged()
    }

    override suspend fun deleteApplication(applicationId: String): Boolean {
        return applicationCollection.deleteOneById(applicationId).wasAcknowledged()
    }

}