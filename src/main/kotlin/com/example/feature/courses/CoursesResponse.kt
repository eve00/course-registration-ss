package com.example.feature.courses

import com.example.feature.courses.module.CourseListResponse
import com.example.feature.courses.module.RegistrationRequestResponse
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
val registrationRequestResponseModule = SerializersModule {
    polymorphic(Any::class) {
        subclass(RegistrationRequestResponse::class)
    }
}


val formatCourses = Json {
    serializersModule = responseModule + courseListResponseModule
}

val formatRegistrations = Json {
    serializersModule = responseModule + registrationRequestResponseModule

}