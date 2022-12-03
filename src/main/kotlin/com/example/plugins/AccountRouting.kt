package com.example.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureAccountRouting() {

    routing {

        route(path = "/account/register") {
            get {
                call.respondText("register")
            }

            post {

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