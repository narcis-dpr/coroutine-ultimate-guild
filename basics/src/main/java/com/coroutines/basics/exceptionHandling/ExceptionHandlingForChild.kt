package com.coroutines.basics.exceptionHandling

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.IllegalStateException

fun main() = runBlocking {
    val handler = CoroutineExceptionHandler { _, exception ->
        println(
            "Caught $exception with suppressed " +
                exception.suppressed.contentToString(),
        )
    }
    // parent job
    val parentJob = GlobalScope.launch(handler) {
        // child job 1
        launch {
            try {
                delay(Long.MAX_VALUE)
            } catch (e: Exception) {
                println("${e.javaClass.simpleName} in Child job 1")
            } finally {
                throw ArithmeticException()
            }
        }
        // child job 2
        launch {
            delay(100)
            throw IllegalStateException()
        }
        delay(Long.MAX_VALUE) // delaying the parent
    }
    parentJob.join()
}
