package com.coroutines.advanced.flowOfData

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
fun main() {
    val flowOfString = flow {
        for (number in 0..100) {
            emit("Emitting $number")
        }
    }

    GlobalScope.launch {
        flowOfString.collect { value ->
            println(value)
        }
    }
    Thread.sleep(1000)
}
