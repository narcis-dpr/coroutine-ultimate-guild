package com.coroutines.advanced.flowOfData

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
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
            .flowOn(Dispatchers.IO)
            .onEach { delay(100) }
            .flowOn(Dispatchers.Default)
            .collect { value ->
                println(value)
            }
    }
}
