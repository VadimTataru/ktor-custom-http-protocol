package com.example.plugins

import com.example.domain.model.AccountUser
import com.example.domain.model.users
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureAccountRouting() {

    routing {

        route(path = "/account/register") {
            get {
                call.respondText("register")
            }

            post {
                val user = call.receive<AccountUser>()
                users.add(user)
                call.respondText("Customer stored correctly", status = HttpStatusCode.Created)
            }
        }

        route(path = "/account/login") {
            get {
                call.respondText("login")
            }

            post {

            }
        }

        route(path = "/account/logout") {
            get {
                call.respondText("logout")
            }

            post {

            }
        }
    }

}