package com.coroutines.advanced.manageCancellation

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

fun main() = runBlocking {
    withTimeout(1500L) {
        repeat(1000) { i ->
            println("$i. Crunching numbers [Beep.Boop.Beep]...")
            delay(500L)
        }
    }
}
