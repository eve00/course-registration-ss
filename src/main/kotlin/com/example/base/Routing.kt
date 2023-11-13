package com.example.base

import com.example.di.repository.RepositoryLocator
import com.example.di.service.ServiceLocator
import com.example.di.service.ServiceLocator.provideApplicationApiService
import io.ktor.server.application.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import com.example.feature.apply.applicationsRoute

fun Application.configureRouting() {
    applicationsRoute(domainLocator.provideDomainProvider())
  /*  routing {
        get("/") {
            call.respondText("Hello World!")
        }


    }*/
}
