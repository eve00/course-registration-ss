package com.example.feature.courses.service

import com.example.feature.courses.module.Course
import com.example.feature.courses.module.RegistrationRequest
import com.mongodb.client.MongoCollection
import com.mongodb.client.model.Filters
import com.mongodb.client.model.Updates
import org.bson.Document

class CourseManagementApiServiceImpl(private val coursesCollection: MongoCollection<Document>) :
    CourseManagementApiService {
    override suspend fun getAllCourses(): List<Course> {
        return coursesCollection.find().toList().map { document ->
            Course(
                courseId = document.getString("courseId"),
                name = document.getString("name"),
                capacity = document.getInteger("capacity"),
            )
        }
    }

    override suspend fun updateCourseRegistrations(request: RegistrationRequest): Boolean {
        val studentIds: List<String> = request.studentIds
        val studentIdsData = coursesCollection.find(
            Filters.eq("_id", request.courseId),
        ).toList()[0].get("studentIds") as List<String>

        val data = if (studentIdsData.isEmpty()) {
            studentIds
        } else {
            listOf(studentIdsData, studentIds).flatten()
        }
        println()
        return coursesCollection.updateOne(
            Filters.eq("_id", request.courseId),
            Updates.set("studentIds", data)
        ).wasAcknowledged()
    }
}