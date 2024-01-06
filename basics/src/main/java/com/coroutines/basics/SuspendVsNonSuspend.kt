package com.coroutines.basics

fun main() {
}

fun getUserStandard(userId: String): User {
    Thread.sleep(1000)
    return User(userId, "Filip")
}

data class User(
    val id: String,
    val name: String,
)
