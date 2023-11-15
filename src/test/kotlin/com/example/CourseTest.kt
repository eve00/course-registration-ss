package com.example

import com.example.feature.courses.module.RegistrationRequest
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.testing.*
import org.junit.Test
import kotlin.test.assertEquals

class CourseTest {
    @Test
    fun testGetCourses() = testApplication {


        val response = client.get("/courses")
        println(response.bodyAsText())
        assertEquals(HttpStatusCode.OK, response.status)
    }

    @Test
    fun testCreateRegistration() = testApplication {

        val client = createClient {
            install(ContentNegotiation) {
                json()
            }
        }
        val registrations = listOf("hoge1","hoge2", "hoge3")
        val request = RegistrationRequest(
            courseId = "00001",
            studentIds = registrations
        )

        val response = client.post("/courses") {
            contentType(ContentType.Application.Json)
            setBody(
               request
            )
        }
        assertEquals(HttpStatusCode.OK, response.status)
    }




}