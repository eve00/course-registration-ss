package com.example.feature.apply


import com.example.di.domain.DomainProvider
import com.example.util.getBodyContent
import io.ktor.resources.*
import io.ktor.server.application.*
import io.ktor.server.resources.*
import io.ktor.server.resources.post
import io.ktor.server.response.*
import io.ktor.server.routing.*

@Resource("/applications")
class Applications() {
    @Resource("new")
    class New()

    @Resource("{id}")
    class Id()
}

fun Route.applicationsRoute(
    domainProvider: DomainProvider
) {
    post<Applications.New> {
        val application = getBodyContent<Application>()
        val response = domainProvider.provideCreateApplicationUseCase().invoke(application)
        call.respond(response)
    }

    delete<Applications.Id> { id ->
        val application = getBodyContent<Application>()
        val response = domainProvider.provideDeleteApplicationUseCase().invoke(application)
        call.respond(response)

    }
}
