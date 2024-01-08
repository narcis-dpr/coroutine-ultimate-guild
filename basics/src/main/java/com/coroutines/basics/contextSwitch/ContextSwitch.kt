package com.coroutines.basics.contextSwitch

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

fun main() {
    GlobalScope.launch {
        println("This is a coroutine")
    }
    Thread.sleep(50)
}
