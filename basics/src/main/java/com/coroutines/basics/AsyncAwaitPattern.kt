package com.coroutines.basics

fun main() {
    val userId = 992
    getUserByIdFromNetwork(userId) { user ->
        println(user)
    }
}

private fun getUserByIdFromNetwork(userId: Int, onUserReady: (AsyncUser) -> Unit) {
    Thread.sleep(3000)
    onUserReady(AsyncUser(userId, "Filip", "Babic"))
}

internal data class AsyncUser(
    val userId: Int,
    val name: String,
    val lastName: String,
)
