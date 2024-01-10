package com.coroutines.advanced.manageCancellation

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = launch {
        println("Crunching Numbers [Beep.Boop.Beep]...")
        delay(1000L)
    }
    // waiting for completion :
    job.join()
    println("main: now i can quit ")
}
