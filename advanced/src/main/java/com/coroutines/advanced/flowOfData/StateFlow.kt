package com.coroutines.advanced.flowOfData

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

fun main() {
    val coroutineScope = CoroutineScope(Dispatchers.Default)
    val stateFlow = MutableStateFlow("Author: Filip")

    println(stateFlow.value) // accesses value without subscribing

    coroutineScope.launch { // access values with subscribing
        stateFlow.collect {
            println(it)
        }
    }
    while (coroutineScope.isActive) {
    }
}
