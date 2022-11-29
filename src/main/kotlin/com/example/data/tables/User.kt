package com.example.data.tables

import org.jetbrains.exposed.sql.Table

object User: Table(name = "user") {
    val id = User.integer("id").autoIncrement().entityId()
    val login = User.text("login")
    val password = User.text("password")
}