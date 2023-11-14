package com.example.base

import com.example.di.domain.DomainLocator
import com.example.feature.applications.applicationsRoute
import com.example.feature.courses.coursesRoute
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.resources.*
import io.ktor.server.routing.*


val domainLocator = DomainLocator
fun Application.configureRoutingAndSerialization() {
    install(Resources)
    install(ContentNegotiation) {
        json()
    }
    routing {
        applicationsRoute(domainLocator.provideDomainProvider())
        coursesRoute(domainLocator.provideDomainProvider())
    }

}
