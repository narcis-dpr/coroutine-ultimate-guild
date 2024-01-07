package com.coroutines.basics

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.File

fun main() {
    val userId = 992

    /**
     *
     * callback pattern
     getUserByIdFromNetwork(userId) { user ->
     println(user)
     }
     */
    /**
     *
     Async/Await pattern
     GlobalScope.launch {
     val userData = getUserByIdFromNetwork(userId)
     println(userData.await())
     }
     Thread.sleep(5000)
     */
    val launch = GlobalScope.launch {
        println("Finding user")
        val userDeferred = getUserByIdFromNetwork(userId) // deferred number one
        val usersFromFileDeferred = readUsersFromFile("basics/users.txt") // deferred number two

        val userStoredInFile = checkUserExists(
            userDeferred.await(),
            usersFromFileDeferred.await(),
        ) // combining two deferred

        if (userStoredInFile) {
            println("Found user in file")
        }
    }
    Thread.sleep(50)
    launch.cancel()
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

private fun readUsersFromFile(filePath: String) = GlobalScope.async {
    println("Reading the file of users")
    delay(1000)

    File(filePath)
        .readLines()
        .asSequence()
        .filter { it.isNotEmpty() }
        .map {
            val data = it.split(" ") // makes it : [id, name, lastName]

            if (data.size == 3) data else emptyList()
        }
        .filter { it.isNotEmpty() }
        .map {
            val userId = it[0].toInt()
            val name = it[1]
            val lastName = it[2]

            AsyncUser(userId, name, lastName)
        }
        .toList()
}

private fun checkUserExists(user: AsyncUser, users: List<AsyncUser>):
    Boolean {
    return user in users
}

internal data class AsyncUser(
    val userId: Int,
    val name: String,
    val lastName: String,
)
