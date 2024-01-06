package com.coroutines.basics

import kotlin.concurrent.thread

fun main() {
    getUserFromNetworkCallback("202") { user ->
        println(user)
    }
    println("main end")
}

fun getUserStandard(userId: String): User {
    Thread.sleep(1000)
    return User(userId, "Filip")
}

fun getUserFromNetworkCallback(
    userId: String,
    onUserReady: (User) -> Unit,
) {
    thread {
        Thread.sleep(1000)

        val user = User(userId, "Filip")
        onUserReady(user)
    }
    println("end")
}

data class User(
    val id: String,
    val name: String,
)
