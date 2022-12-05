package com.example.features.account.domain.model
import kotlinx.serialization.Serializable

@Serializable
data class AccountUser(
    val login: String,
    val password: String,
    val email: String
)

val users = mutableListOf<AccountUser>()
