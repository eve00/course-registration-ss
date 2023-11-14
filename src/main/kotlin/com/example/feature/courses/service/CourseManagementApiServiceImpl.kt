package com.example.feature.courses.service

import com.mongodb.client.MongoCollection
import org.bson.Document

class CourseManagementApiServiceImpl(private val coursesCollection: MongoCollection<Document>) :
    CourseManagementApiService {
    override suspend fun getAllCourses(): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun createRegistrations(): Boolean {
        TODO("Not yet implemented")
    }
}