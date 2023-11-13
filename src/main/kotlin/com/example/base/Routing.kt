package com.example.base

import com.example.di.domain.DomainLocator
import com.example.feature.apply.applicationsRoute
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.resources.*
import io.ktor.server.routing.*
import io.ktor.serialization.kotlinx.json.*


val domainLocator = DomainLocator
fun Application.configureRoutingAndSerialization() {
    install(Resources)
    install(ContentNegotiation) {
        json()
    }
    routing {
        applicationsRoute(domainLocator.provideDomainProvider())

    }
  /*  routing {
        get("/") {
            call.respondText("Hello World!")
        }


    }*/
}
