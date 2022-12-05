package com.example.features.account.data.dao

import com.example.database.core.DatabaseFactory.dbQuery
import com.example.features.account.data.model.UserDto
import com.example.database.tables.User
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class UserDaoImpl: UserDao {
    private fun resultRowIntoUser(row: ResultRow) = UserDto(
        login = row[User.login],
        password = row[User.password]
    )

    override suspend fun getUsers(): List<UserDto> = dbQuery {
        User.selectAll().map(::resultRowIntoUser)
    }

    override suspend fun getUserById(login: String): UserDto? = dbQuery {
        User.select(User.login eq login).map(::resultRowIntoUser).singleOrNull()
    }

    override suspend fun addUser(user: UserDto): Unit = dbQuery {
        User.insert {
            it[login] = user.login
            it[password] = user.password
        }
    }

    override suspend fun updateUser(user: UserDto): Boolean = dbQuery {
        User.update({ User.login eq user.login }) {
            it[password] = user.password
        } > 0
    }

    override suspend fun deleteUser(login: String): Boolean = dbQuery {
        User.deleteWhere { User.login eq login } > 0
    }
}