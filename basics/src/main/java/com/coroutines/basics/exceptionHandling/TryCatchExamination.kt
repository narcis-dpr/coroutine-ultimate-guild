package com.coroutines.basics.exceptionHandling

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

@OptIn(DelicateCoroutinesApi::class)
fun main() {
    runBlocking {
        val callAwaitOnDeferred = false // true

        val deferred = GlobalScope.async {
            println("Throwing exception from async")
            throw ArithmeticException("Something went wrong")
        }

        if (callAwaitOnDeferred) {
            try {
                deferred.await()
            } catch (e: ArithmeticException) {
                println("Caught Arithmetic Exception")
            }
        }
    }
}
