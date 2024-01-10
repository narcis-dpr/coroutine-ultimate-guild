package com.coroutines.advanced.manageCancellation

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = launch {
        repeat(1000) { i ->
            println("$i. Crunching numbers [Beep.Boop.Beep]...")
            delay(500L)
        }
    }
    delay(1300L)
    println("main: im tired of waiting!")
    job.cancelAndJoin()
    println("main: now i can quit.")
}

/**
 * without cancelAndJoin the launch first at the start and never stops until it
 * finishes, meanwhile the outside of launch block runs after
 * 1300 milli seconds
 *
 * with cancel and join the launch block runs only for
 * 1300 milli second
 */
