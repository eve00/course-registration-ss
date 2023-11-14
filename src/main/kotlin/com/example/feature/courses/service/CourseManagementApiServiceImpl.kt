package com.example.feature.courses.service

import com.example.feature.courses.module.Course
import com.example.feature.courses.module.Registration
import com.mongodb.client.MongoCollection
import org.bson.Document

class CourseManagementApiServiceImpl(private val coursesCollection: MongoCollection<Document>) :
    CourseManagementApiService {
    override suspend fun getAllCourses(): List<Course> {
        return coursesCollection.find().toList().map { document ->
            Course(
                courseId = document.getString("courseId"),
                name = document.getString("name"),
                capacity = document.getInteger("capacity"),
                createdAt = document.getString("createAt"),
                updatedAt = document.getString("updatedAt"),
            )
        }
    }

    override suspend fun createRegistrations(studentIds: List<Registration>): Boolean {
        val registration = studentIds.map{id -> Document().append("userId", id) }
        return coursesCollection.insertMany(registration).wasAcknowledged()    }
}