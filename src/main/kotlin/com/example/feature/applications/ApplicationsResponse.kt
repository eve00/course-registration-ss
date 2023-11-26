package com.example.feature.applications

import com.example.feature.applications.module.ApplicationListResponse
import com.example.feature.applications.module.ApplicationResponse
import com.example.util.responseModule
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.plus
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass


val applicationInfoModule = SerializersModule {
    polymorphic(Any::class) {
        subclass(ApplicationResponse::class)
    }
}

val applicationListResponseModule = SerializersModule {
    polymorphic(Any::class) {
        subclass(ApplicationListResponse::class)
    }
}


val formatApplicationsInfo = Json {
    serializersModule = responseModule + applicationInfoModule
}
val applicationsInfo = Json {
    serializersModule = responseModule + applicationListResponseModule
}
