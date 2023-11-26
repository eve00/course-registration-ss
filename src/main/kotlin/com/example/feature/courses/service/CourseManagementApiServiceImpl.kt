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
        val studentIds = coursesCollection.find(
            Filters.eq("_id", request.courseId),
        ).toList()[0].get("studentIds") as List<String>

        val capacity = coursesCollection.find(
            Filters.eq("_id", request.courseId),
        ).toList()[0].getInteger("capacity")
        val drawedRequestData = when(capacity < request.studentIds.size){
            //ランダム抽選
            true -> request.studentIds.shuffled().subList(0,capacity-1)
            false -> request.studentIds
        }


        val data = if (studentIds.isEmpty()) {
            drawedRequestData
        } else {
            listOf(studentIds, drawedRequestData).flatten()
        }
        return coursesCollection.updateOne(
            Filters.eq("_id", request.courseId),
            Updates.set("studentIds", data)
        ).wasAcknowledged()
    }
}