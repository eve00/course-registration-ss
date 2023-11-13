package com.example.base

import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.resources.*
import org.litote.kmongo.json

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json
    }
    install(Resources)
}