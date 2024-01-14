package com.coroutines.advanced.flowOfData

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

fun main() {
    val flowOfString = flow {
        for (number in 0..100) {
            emit("Emitting $number")
        }
    }
    GlobalScope.launch {
        flowOfString
            .map { it.split(" ") }
            .map { it.last() }
            .onEach { delay(100) }
            .collect { value ->
                println(value)
            }
    }
}
