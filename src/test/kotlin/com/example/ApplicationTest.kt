package com.example

import com.example.feature.apply.module.Application
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.testing.*
import org.bson.types.ObjectId
import org.junit.Test
import java.util.*
import kotlin.test.assertEquals

class ApplicationTest {

    @Test
    fun testCreateApplication() = testApplication {

        val client = createClient {
            install(ContentNegotiation) {
                json()
            }
        }

        val response = client.post("/applications") {
            contentType(ContentType.Application.Json)
            setBody(
                Application(
                    id = ObjectId().toString(),
                    userId = "anonymous",
                    courseId = "something",
                    createdAt = Date().toInstant().toString(),
                    updatedAt = Date().toInstant().toString()
                )
            )
        }
        assertEquals(HttpStatusCode.OK, response.status)
    }

}
