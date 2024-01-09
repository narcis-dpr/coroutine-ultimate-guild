package com.coroutines.basics.exceptionHandling

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import java.lang.IllegalStateException

fun main() = runBlocking {
    supervisorScope { // exception wont propagate upward
        val result = async {
            println("Throwing exception in async")
            throw IllegalStateException()
        }

        try {
            result.await()
        } catch (e: Exception) {
            println("Caught $e")
        }
    }
}
