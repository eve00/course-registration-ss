package com.example.feature.applications

import com.example.feature.courses.module.CourseListResponse
import com.example.feature.courses.module.RegistrationListResponse
import com.example.util.responseModule
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.plus
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass


val courseListResponseModule = SerializersModule {
    polymorphic(Any::class) {
        subclass(CourseListResponse::class)
    }
}
val registrationListResponseModule = SerializersModule {
    polymorphic(Any::class) {
        subclass(RegistrationListResponse::class)
    }
}


val formatCourses = Json {
    serializersModule = responseModule + courseListResponseModule
}

val formatRegistrations = Json {
    serializersModule = responseModule + registrationListResponseModule

}