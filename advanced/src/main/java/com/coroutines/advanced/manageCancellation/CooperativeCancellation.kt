package com.coroutines.advanced.manageCancellation

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (i < 10 && isActive) {
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("Doing heavy work $i")
                i++
                nextPrintTime += 500L
            }
        }
    }
    delay(1000)
    println("Cancelling coroutine")
    job.cancel()
    println("Main: now I can quit!")
}
