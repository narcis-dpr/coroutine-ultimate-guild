package com.coroutines.basics

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.io.File

fun main() {
    val userId = 992
    val scope = CustomScope()
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
    scope.launch {
        println("Finding user")
        val userDeferred = getUserByIdFromNetwork(userId, scope) // deferred number one
        val usersFromFileDeferred = readUsersFromFile("basics/users.txt", scope) // deferred number two

        val userStoredInFile = checkUserExists(
            userDeferred.await(),
            usersFromFileDeferred.await(),
        ) // combining two deferred

        if (userStoredInFile) {
            println("Found user in file")
        }
    }
    scope.onStop()
}

private fun getUserByIdFromNetworkThread(userId: Int, onUserReady: (AsyncUser) -> Unit) {
    Thread.sleep(3000)
    onUserReady(AsyncUser(userId, "Filip", "Babic"))
}

private fun getUserByIdFromNetwork(userId: Int, scope: CoroutineScope) =
    scope.async {
        if (!isActive) {
            return@async AsyncUser(0, "", "")
        }
        println("Retrieving user from network")
        delay(3000)
        AsyncUser(userId, "Filip", "Babic")
    }

private fun readUsersFromFile(filePath: String, scope: CoroutineScope) = scope.async {
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
