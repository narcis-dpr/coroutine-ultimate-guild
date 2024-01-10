package com.coroutines.advanced.manageCancellation

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.IOException

@OptIn(DelicateCoroutinesApi::class)
fun main() = runBlocking {
    val handler = CoroutineExceptionHandler { _, exception ->
        println("Caught original $exception")
    }
    val parentJob = GlobalScope.launch(handler) {
        val childJob = launch {
            throw IOException()
        }

        try {
            childJob.join()
        } catch (e: CancellationException) {
            println(
                "Rethrowing CancellationException with original\n" +
                    "cause: ${e.cause}",
            )

            throw e
        }
    }
    parentJob.join()
}
