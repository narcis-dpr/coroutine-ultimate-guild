package com.coroutines.advanced.flowOfData

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

fun main() {
    val coroutineScope = CoroutineScope(Dispatchers.Default)
    val stateFlow = MutableStateFlow("Author: Filip")

    stateFlow.value = "Author: Luka" // first way of updating: direct
    stateFlow.tryEmit("FPE: Max") // second way of updating: safest

    coroutineScope.launch {
        stateFlow.emit("TE: Godfred") // third way
    }
    coroutineScope.launch {
        stateFlow.collect {
            println(it)
        }
    }
    Thread.sleep(50)
    coroutineScope.cancel()
}
