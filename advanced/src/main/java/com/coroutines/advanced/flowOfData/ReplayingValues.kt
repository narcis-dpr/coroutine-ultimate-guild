package com.coroutines.advanced.flowOfData

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@OptIn(DelicateCoroutinesApi::class)
fun main() {
    val sharedFlow = MutableSharedFlow<Int>(2)
    sharedFlow.tryEmit(5)
    sharedFlow.tryEmit(3)
    sharedFlow.tryEmit(1)

    sharedFlow.onEach {
        println("Emitting $it")
    }.launchIn(GlobalScope)

    sharedFlow.onEach {
        println("Hello $it")
    }.launchIn(GlobalScope)

    Thread.sleep(50)
}
