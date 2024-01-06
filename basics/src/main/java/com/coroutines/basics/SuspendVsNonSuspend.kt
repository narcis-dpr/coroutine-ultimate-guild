package com.coroutines.basics

import kotlin.concurrent.thread

fun main() {
    getUserFromNetworkCallback("202") { user, error ->
        user?.run(::println)
        error?.printStackTrace()
    }
    println("main end")
}

fun getUserStandard(userId: String): User {
    Thread.sleep(1000)
    return User(userId, "Filip")
}

fun getUserFromNetworkCallback(
    userId: String,
    onUserResponse: (User?, Throwable?) -> Unit,
) {
    thread {
        try {
            Thread.sleep(1000)

            val user = User(userId, "Filip")
            onUserResponse(user, null)
        } catch (error: Throwable) {
            onUserResponse(null, error)
        }
    }
    println("end")
}

data class User(
    val id: String,
    val name: String,
)
