package com.example.feature.applications


import com.example.di.domain.DomainProvider
import com.example.feature.applications.module.Application
import com.example.util.getBodyContent
import io.ktor.resources.*
import io.ktor.server.application.*
import io.ktor.server.resources.*
import io.ktor.server.resources.post
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.encodeToJsonElement

@Resource("/applications")
class Applications()

fun Route.applicationsRoute(
    domainProvider: DomainProvider
) {
    post<Applications> {
        val application = getBodyContent<Application>()
        val response = domainProvider.provideCreateApplicationUseCase().invoke(application)
        call.respond(formatApplicationsInfo.encodeToJsonElement(response))
    }

    delete<Applications> {
        val application = getBodyContent<Application>()
        val response = domainProvider.provideDeleteApplicationUseCase().invoke(application)
        call.respond(formatApplicationsInfo.encodeToJsonElement(response))
    }
}
