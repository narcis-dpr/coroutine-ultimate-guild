package com.coroutines.advanced.flowOfData

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

fun main() {
    val coroutineScope = CoroutineScope(Dispatchers.Default)
    val sharedFlow = MutableSharedFlow<Int>()

    sharedFlow.onEach {
        println("Emitting $it")
    }.launchIn(coroutineScope)

    coroutineScope.launch {
        sharedFlow.emit(5)
        sharedFlow.emit(3)
        sharedFlow.emit(1)

        coroutineScope.cancel()
    }

    while (coroutineScope.isActive) {

    }
}
