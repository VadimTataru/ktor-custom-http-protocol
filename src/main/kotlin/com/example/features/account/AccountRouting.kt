package com.example.plugins

import com.example.API_VERSION
import com.example.features.account.domain.model.AccountUser
import com.example.features.account.domain.model.users
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureAccountRouting() {

    routing {

        route(path = "$API_VERSION/account/register") {
            get {
                call.respondText("register")
            }

            post {
                val user = call.receive<AccountUser>()
                users.add(user)
                call.respondText("Customer stored correctly", status = HttpStatusCode.Created)
            }
        }

        route(path = "$API_VERSION/account/login") {
            get {
                call.respondText("login")
            }

            post {

            }
        }

        route(path = "$API_VERSION/account/logout") {
            get {
                call.respondText("logout")
            }

            post {

            }
        }
    }

}