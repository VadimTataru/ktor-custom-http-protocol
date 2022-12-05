package com.example.features.account.data.dao

import com.example.features.account.data.model.UserDto

interface UserDao {
    suspend fun getUsers(): List<UserDto>
    suspend fun getUserById(login: String): UserDto?
    suspend fun addUser(user: UserDto)
    suspend fun updateUser(user: UserDto): Boolean
    suspend fun deleteUser(login: String): Boolean
}