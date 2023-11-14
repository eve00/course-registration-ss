package com.example.feature.courses

import com.example.di.domain.DomainProvider
import com.example.feature.applications.formatCourses
import com.example.feature.applications.formatRegistrations
import com.example.feature.courses.module.Registration
import com.example.util.getBodyContent
import io.ktor.resources.*
import io.ktor.server.application.*
import io.ktor.server.resources.*
import io.ktor.server.resources.post
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.encodeToJsonElement


@Resource("/courses")
class Courses(){
    @Resource("{id}")
    class Id()
}

fun Route.coursesRoute(
    domainProvider: DomainProvider
) {
    get<Courses>{
        val response = domainProvider.provideGetAllCoursesUseCase().invoke()
        call.respond(formatCourses.encodeToJsonElement(response))
    }

    post<Courses.Id> {
        val registrations = getBodyContent<List<Registration>>()
        val response = domainProvider.provideCreateRegistrationsUseCase().invoke(registrations)
        call.respond(formatRegistrations.encodeToJsonElement(response))
    }


}
