package com.coroutines.basics.exceptionHandling

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val supervisor = SupervisorJob()

    with(CoroutineScope(coroutineContext + supervisor)) {
        val firstChild = launch {
            println("First child throwing an exception")
            throw ArithmeticException()
        }
        val secondChild = launch {
            println("first child is cancelled: ${firstChild.isCancelled}")
            try {
                delay(5000)
            } catch (e: CancellationException) {
                println("Second child canelled because supervisor got cancelled.")
            }
        }
        firstChild.join()
        supervisor.cancel()
        secondChild.join()
    }
}
