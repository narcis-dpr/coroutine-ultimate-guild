package com.coroutines.advanced.flowOfData

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.isActive

fun main() {
    val coroutineScope = CoroutineScope(Dispatchers.Default)
    val sharedFlow = flow {
        emit(5)
        emit(3)
        emit(1)
        Thread.sleep(50)
        coroutineScope.cancel()
    }.shareIn(coroutineScope, started = SharingStarted.Lazily)

    sharedFlow.onEach {
        println("Emitting $it")
    }.launchIn(coroutineScope)

    while (coroutineScope.isActive) {
    }
}
/**
 * using sharedIn we transform a flow into a shredFlow
 * started = SharingStarted.Lazily : waits for the first subscriber
 */
