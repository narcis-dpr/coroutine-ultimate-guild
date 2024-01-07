package com.coroutines.basics

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

fun main() {
    val userId = 992

    /**
     *
     * callback pattern
     getUserByIdFromNetwork(userId) { user ->
     println(user)
     }
     */
    GlobalScope.launch {
        val userData = getUserByIdFromNetwork(userId)
        println(userData.await())
    }
    Thread.sleep(5000)
}

private fun getUserByIdFromNetworkThread(userId: Int, onUserReady: (AsyncUser) -> Unit) {
    Thread.sleep(3000)
    onUserReady(AsyncUser(userId, "Filip", "Babic"))
}
private fun getUserByIdFromNetwork(userId: Int) =
    GlobalScope.async {
        println("Retrieving user from network")
        Thread.sleep(3000)
        AsyncUser(userId, "Filip", "Babic")
    }

internal data class AsyncUser(
    val userId: Int,
    val name: String,
    val lastName: String,
)
