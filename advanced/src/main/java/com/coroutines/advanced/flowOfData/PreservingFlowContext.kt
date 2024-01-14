package com.coroutines.advanced.flowOfData

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * this ends up in a exception saying: you cant change the flow concurrency
 *
 */
@OptIn(DelicateCoroutinesApi::class)
fun mainBroken() {
    // this is a violation :
    val flowOfString = flow {
        for (number in 0..100) {
            GlobalScope.launch {
                emit("Emitting $number")
            }
        }
    }
    GlobalScope.launch {
        flowOfString.collect {
            println(it)
        }
    }
}

@OptIn(DelicateCoroutinesApi::class)
fun main() {
    val flowOfString = flow {
        for (number in 0..100) {
            withContext(Dispatchers.IO) {
                emit("Emitting $number")
            }
        }
    }
    GlobalScope.launch {
        flowOfString.collect {
            println(it)
        }
    }
}
